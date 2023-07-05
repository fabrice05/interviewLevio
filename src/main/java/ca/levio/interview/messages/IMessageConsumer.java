package ca.levio.interview.messages;

import ca.levio.interview.dtos.NotificationMessagingDto;

public interface IMessageConsumer {
   public void readMessage(NotificationMessagingDto msg);
}
