package ca.levio.interview.messages.Kafka;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.SkillInterview;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.SkillInterviewRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorRepository;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.MessageConsumer;
import ca.levio.interview.services.INotificationMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer implements MessageConsumer {
    private final SkillInterviewRepository skillInterviewRepository;
    private final InterviewRepository interviewRepository;
    private final JobPositionRepository jobPositionRepository;
    private final INotificationMessage mail;
    private final TechnicalAdvisorRepository technicalAdvisorRepository;

    public KafkaConsumer(SkillInterviewRepository skillInterviewRepository,
                         InterviewRepository interviewRepository,
                         JobPositionRepository jobPositionRepository,
                         INotificationMessage mail, TechnicalAdvisorRepository technicalAdvisorRepository) {
        this.skillInterviewRepository = skillInterviewRepository;
        this.interviewRepository = interviewRepository;
        this.jobPositionRepository = jobPositionRepository;
        this.mail = mail;
        this.technicalAdvisorRepository = technicalAdvisorRepository;
    }

    @KafkaListener(topics = "${interview_creation}", groupId ="${interview_creation.consumer.group-id}" )
   public void readMessage(NotificationMessagingDto messaging){
        //Read Information to Kafka
        // Create Link in database betWeen each Potential TechnicalAdvisor With Interview
        Interview interview =interviewRepository.getReferenceById(messaging.getInterviewId());
        JobPosition jobPosition =jobPositionRepository.getReferenceById(messaging.getJobPositionId());
        TechnicalAdvisor technicalAdvisor= technicalAdvisorRepository.getReferenceById(messaging.getTechnicalAdvisorcanditateId());
        SkillInterview skill=new SkillInterview(messaging.getStatus(),interview,jobPosition );
        skill.setTechnicalAdvisor(technicalAdvisor);
        skill.setFirstChoiceTechnical(messaging.getPreselectedTechnicalAdvisor());
        skillInterviewRepository.save(skill);
        skillInterviewRepository.flush();

        // Call Message Sending



        mail.sendEmail(messaging.getCandidateName(),messaging.getTechnicalAdvisorEmail(),new String("fabrice.ngadjeu@gmail.com"),"Ceci est un test de Message");

    }

}
