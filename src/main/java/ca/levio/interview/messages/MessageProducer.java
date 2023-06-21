package ca.levio.interview.messages;

import ca.levio.interview.dtos.NotificationMessagingDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

public interface MessageProducer {
    public void writeMessage(NotificationMessagingDto msg);
}
