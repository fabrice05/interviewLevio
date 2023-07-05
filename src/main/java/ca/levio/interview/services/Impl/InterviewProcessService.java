package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.*;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.IMessageProducer;
import ca.levio.interview.services.IDtoAndEntityConversion;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InterviewProcessService //implements IInterviewProcess
{
    private final TechnicalAdvisorChekingService technical;
    private  final IMessageProducer messageProducer;
    final ITechnicalAdvisorInterviewRepository technicalAdvisorInterviewRepository;
    final IInterviewRepository interviewRepository;
    private IJobPositionRepository jobPositionRepository;
    final ITechnicalAdvisorRepository technicalAdvisorRepository;

    public InterviewProcessService(TechnicalAdvisorChekingService technical, IMessageProducer messageProducer, ITechnicalAdvisorInterviewRepository
            technicalAdvisorInterviewRepository, IInterviewRepository interviewRepository, IJobPositionRepository jobPositionRepository, ITechnicalAdvisorRepository  technicalAdvisorRepository) {
        this.technical = technical;
        this.messageProducer = messageProducer;
        this.technicalAdvisorInterviewRepository = technicalAdvisorInterviewRepository;
        this.interviewRepository = interviewRepository;
        this.jobPositionRepository = jobPositionRepository;
        this.technicalAdvisorRepository = technicalAdvisorRepository;
    }
    private List<InterviewDto> mapList(List<Interview> source) {
        return  source
                .stream()
                .map(element -> DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(element))
                .collect(Collectors.toList());
    }

    public List<InterviewDto> getAll() {
        return mapList(interviewRepository.findAll());
    }

    public  InterviewDto getApplicant(UUID id) {
        Interview element_jpa=  interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return  DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(element_jpa);
    }

    public InterviewDto createOrUpdate(InterviewDto interviewDto) {
        Interview interview = DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(interviewDto);
        interview= interviewRepository.save(interview);
        // Map Messaging to Works
        createTechnicalChoise(interview);
        //
        return  DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(interview);
    }
    public void delete(UUID id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public String toString() {
        return "InterviewService{" +
                "repository=" + interviewRepository.findAll()+ "}";
    }


    public void createTechnicalChoise(Interview interview) {
        List<ViewTechnicalAdvisorAndSkill> setTechnical= technical.getListTechnicalAdvisor(interview);
        setTechnical.forEach(tech->
        {
            TechnicalAdvisorInterview skillInterview=new TechnicalAdvisorInterview("OPEN",interview);
            NotificationMessagingDto messagingDto=new NotificationMessagingDto(tech.getTechnicalAdvisorId(),"OPEN",false, interview.getId(),
                interview.getDescription(), interview.getInterviewType(),interview.isUrgent(),interview.getInterviewStatus(), interview.getCandidateName(),
                tech.getJobName(),tech.getLevelOfExpertise(),interview.getRecruiterName(), interview.getRecruiterEmail(),
                tech.getTechnicalAdvisorEmail(),
                    interview.getJobPosition()
                    ,interview.getLevelOfExpertiseCandidate(),tech.getJobPositionId());
            System.out.println("Technical "+tech.getTechnicalAdvisorEmail() + " "+tech.getTechnicalAdvisorName());
            messageProducer.writeMessage(messagingDto);
        });
    }
    public UUID SaveTechnicalCanadidateInterview(NotificationMessagingDto messaging){
        //Read Information to Kafka
        // Create Link in database betWeen each Potential TechnicalAdvisor With Interview
        Interview interview =interviewRepository.getReferenceById(messaging.getInterviewId());
        JobPosition jobPosition =jobPositionRepository.getReferenceById(messaging.getJobPositionId());
        TechnicalAdvisor technicalAdvisor= technicalAdvisorRepository.getReferenceById(messaging.getTechnicalAdvisorcanditateId());
        TechnicalAdvisorInterview skill=new TechnicalAdvisorInterview(messaging.getStatus(),interview);
        skill.setTechnicalAdvisor(technicalAdvisor);
        skill.setFirstChoiceTechnical(messaging.getPreselectedTechnicalAdvisor());
        skill=technicalAdvisorInterviewRepository.save(skill);
        return skill.getId();
    }
}
