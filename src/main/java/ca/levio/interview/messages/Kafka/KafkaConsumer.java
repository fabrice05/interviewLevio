package ca.levio.interview.messages.Kafka;

import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.IMessageConsumer;
import ca.levio.interview.services.INotificationMessage;
import ca.levio.interview.services.Impl.InterviewProcessService;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumer implements IMessageConsumer {
    private final INotificationMessage mail;
    private final InterviewProcessService interviewProcessService;

    public KafkaConsumer(INotificationMessage mail, InterviewProcessService interviewProcessService) {
        this.mail = mail;
        this.interviewProcessService = interviewProcessService;
    }

    @KafkaListener(topics = "${interview_creation}", groupId ="${interview_creation.consumer.group-id}" )
    public void readMessage(NotificationMessagingDto messaging){
      UUID SkillInterViewTechnicalId=interviewProcessService.SaveTechnicalCanadidateInterview(messaging);
       // Topic Interview Creation and Notification

        try {
            mail.sendHtmlMessage("/sendMailNotification",messaging,SkillInterViewTechnicalId);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
