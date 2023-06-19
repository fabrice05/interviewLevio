package ca.levio.interview.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${topic.name.consumer}")
    private String topicName;
    private KafkaTemplate<String, String> kafkaTemplate;
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void WriteMessage(String msg){
        this.kafkaTemplate.send(topicName,msg);
    }
}
