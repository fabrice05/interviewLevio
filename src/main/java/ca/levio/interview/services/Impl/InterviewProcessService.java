package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.MessageProducer;
import ca.levio.interview.services.DtoAndEntityConversion;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InterviewProcessService implements IInterviewProcess {
    private final InterviewRepository repository;
    private final TechnicalAdvisorCheking technical;
    private  final MessageProducer messageProducer;

    public InterviewProcessService(InterviewRepository repository, TechnicalAdvisorCheking technical, MessageProducer messageProducer) {
        this.repository = repository;
        this.technical = technical;
        this.messageProducer = messageProducer;
    }
    private List<InterviewDto> mapList(List<Interview> source) {
        return  source
                .stream()
                .map(element -> DtoAndEntityConversion.MAPPER.mapJPAtoDTO(element))
                .collect(Collectors.toList());
    }

    public List<InterviewDto> getAll() {
        return mapList(repository.findAll());
    }

    public  InterviewDto getApplicant(UUID id) {
        Interview element_jpa=  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return  DtoAndEntityConversion.MAPPER.mapJPAtoDTO(element_jpa);
    }

    public InterviewDto createOrUpdate(InterviewDto interviewDto) {
        Interview interview = DtoAndEntityConversion.MAPPER.mapDTOtoEntity(interviewDto);
        interview= repository.save(interview);
        // Map Messaging to Works
        createTechnicalChoise(interview);
        //
        return  DtoAndEntityConversion.MAPPER.mapJPAtoDTO(interview);
    }
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public String toString() {
        return "InterviewService{" +
                "repository=" + repository.findAll()+ "}";
    }


    public void createTechnicalChoise(Interview interview) {
        List<TechnicalAdvisorAndSkill> setTechnical= technical.getListTechnicalAdvisor(interview);
        setTechnical.forEach(tech->
        {
            SkillInterview skillInterview=new SkillInterview("OPEN",interview,new JobPosition(tech.getJobPositionId()));
            NotificationMessagingDto messagingDto=new NotificationMessagingDto(tech.getTechnicalAdvisorId(),"OPEN",false, interview.getId(),
                interview.getDescription(), interview.getInterviewType(),interview.getUrgent(),interview.getInterviewStatus(), interview.getCandidateName(),
                tech.getJobName(),tech.getLevelOfExpertise(),interview.getRecruiterName(), interview.getRecruiterEmail(),
                tech.getTechnicalAdvisorEmail(),
                    interview.getJobPosition()
                    ,interview.getLevelOfExpertise(),tech.getJobPositionId());
            System.out.println("Technical "+tech.getTechnicalAdvisorEmail() + " "+tech.getTechnicalAdvisorName());
            messageProducer.writeMessage(messagingDto);
        });
    }

}
