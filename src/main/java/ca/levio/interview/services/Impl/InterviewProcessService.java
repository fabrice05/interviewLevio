package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.SkillInterviewRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorRepository;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.SkillInterviewDto;
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
    private final TechnicalAdvisorCheking technical;
    private  final MessageProducer messageProducer;
    private final SkillInterviewRepository skillInterviewRepository;
    private final InterviewRepository interviewRepository;
    private JobPositionRepository jobPositionRepository;
    private final TechnicalAdvisorRepository technicalAdvisorRepository;

    public InterviewProcessService(TechnicalAdvisorCheking technical, MessageProducer messageProducer, SkillInterviewRepository skillInterviewRepository, InterviewRepository interviewRepository, JobPositionRepository jobPositionRepository, TechnicalAdvisorRepository technicalAdvisorRepository) {
        this.technical = technical;
        this.messageProducer = messageProducer;
        this.skillInterviewRepository = skillInterviewRepository;
        this.interviewRepository = interviewRepository;
        this.jobPositionRepository = jobPositionRepository;
        this.technicalAdvisorRepository = technicalAdvisorRepository;
    }
    private List<InterviewDto> mapList(List<Interview> source) {
        return  source
                .stream()
                .map(element -> DtoAndEntityConversion.MAPPER.mapEntitytoDTO(element))
                .collect(Collectors.toList());
    }

    public List<InterviewDto> getAll() {
        return mapList(interviewRepository.findAll());
    }

    public  InterviewDto getApplicant(UUID id) {
        Interview element_jpa=  interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return  DtoAndEntityConversion.MAPPER.mapEntitytoDTO(element_jpa);
    }

    public InterviewDto createOrUpdate(InterviewDto interviewDto) {
        Interview interview = DtoAndEntityConversion.MAPPER.mapDTOtoEntity(interviewDto);
        interview= interviewRepository.save(interview);
        // Map Messaging to Works
        createTechnicalChoise(interview);
        //
        return  DtoAndEntityConversion.MAPPER.mapEntitytoDTO(interview);
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
    public UUID SaveTechnicalCanadidateInterview(NotificationMessagingDto messaging){
        //Read Information to Kafka
        // Create Link in database betWeen each Potential TechnicalAdvisor With Interview
        Interview interview =interviewRepository.getReferenceById(messaging.getInterviewId());
        JobPosition jobPosition =jobPositionRepository.getReferenceById(messaging.getJobPositionId());
        TechnicalAdvisor technicalAdvisor= technicalAdvisorRepository.getReferenceById(messaging.getTechnicalAdvisorcanditateId());
        SkillInterview skill=new SkillInterview(messaging.getStatus(),interview,jobPosition );
        skill.setTechnicalAdvisor(technicalAdvisor);
        skill.setFirstChoiceTechnical(messaging.getPreselectedTechnicalAdvisor());
        skill=skillInterviewRepository.save(skill);
        return skill.getId();
    }

    @Override
    public SkillInterviewDto linkInterviewTechnicalAccept(UUID skillId) {
        SkillInterview skill=skillInterviewRepository.getReferenceById(skillId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        skill.setStatus("ACCEPT");
        skillInterviewRepository.save(skill);
        return null;
    }

    @Override
    public SkillInterviewDto linkInterviewTechnicalReject(UUID skillId) {
        SkillInterview skill=skillInterviewRepository.getReferenceById(skillId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        //si c'est la personne par defaut supprimer la liaison, voir si d'autres ont accepté et choisi un autre par défaut
        skill.setStatus("REJECT");


        skillInterviewRepository.save(skill);
        return null;
    }
}
