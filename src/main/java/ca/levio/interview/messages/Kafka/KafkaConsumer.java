package ca.levio.interview.messages.Kafka;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;
import ca.levio.interview.messages.IMessageConsumer;
import ca.levio.interview.services.INotificationMessage;
import ca.levio.interview.services.Impl.InterviewProcessService;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumer implements IMessageConsumer {
    private final InterviewProcessService interviewProcessService;

    public KafkaConsumer( InterviewProcessService interviewProcessService) {
        this.interviewProcessService = interviewProcessService;
    }

    @KafkaListener(topics = "${interview_creation}", groupId ="${interview_creation.consumer.group-id}" )
    public void readMessage(InterviewDto messaging){
           interviewProcessService.createTechnicalInterview(messaging);
       // Topic Interview Creation and Notification
    }

    @Override
    @KafkaListener(topics = "${interview_advisor_creation}", groupId ="${interview_creation.consumer.group-id}" )
    public void readMessage(TechnicalAdvisorInterviewDto msg) {
        interviewProcessService.sendInvitationTechnical(msg);

    }
}
