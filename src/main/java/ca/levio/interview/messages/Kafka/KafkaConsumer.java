package ca.levio.interview.messages.Kafka;

import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.messages.MessageConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer implements MessageConsumer {
    @KafkaListener(topics = "${interview_creation}", groupId ="${interview_creation.consumer.group-id}" )
   public void readMessage(NotificationMessagingDto msg){
        System.out.println("My Consommer "+msg);
    }
}
