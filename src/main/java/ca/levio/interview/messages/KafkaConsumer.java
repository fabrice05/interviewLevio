package ca.levio.interview.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "${topic.name.consumer}", groupId ="${spring.kafka.consumer.group-id}" )
   public void WriteMessage(String msg){
        System.out.println("My Consommer "+msg);
    }
}
