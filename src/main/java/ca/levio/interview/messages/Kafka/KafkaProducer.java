package ca.levio.interview.messages.Kafka;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;
import ca.levio.interview.messages.IMessageProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer implements IMessageProducer {

    @Value("${interview_creation}")
    private String topicInterviewCreation;

    @Value("${interview_advisor_creation}")
    private String topicAdvisorInterview;
    private KafkaTemplate<String, Object> kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void writeMessage(InterviewDto msg){
        this.kafkaTemplate.send(topicInterviewCreation,msg);
    }
    public void writeMessage(TechnicalAdvisorInterviewDto msg){
        this.kafkaTemplate.send(topicAdvisorInterview,msg);
    }
}
