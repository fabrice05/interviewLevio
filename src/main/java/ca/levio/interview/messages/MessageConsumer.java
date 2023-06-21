package ca.levio.interview.messages;

import ca.levio.interview.dtos.NotificationMessagingDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

public interface MessageConsumer {
   public void readMessage(NotificationMessagingDto msg);
}
