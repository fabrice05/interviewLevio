package ca.levio.interview.messages.Kafka;

import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.MessageProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer implements MessageProducer {

    @Value("${interview_creation}")
    private String topicName;
    private KafkaTemplate<String, NotificationMessagingDto> kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String, NotificationMessagingDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void writeMessage(NotificationMessagingDto msg){
        this.kafkaTemplate.send(topicName,msg);
    }
}
