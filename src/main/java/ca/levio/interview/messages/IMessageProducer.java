package ca.levio.interview.messages;

import ca.levio.interview.dtos.NotificationMessagingDto;

public interface IMessageProducer {
    public void writeMessage(NotificationMessagingDto msg);
}
