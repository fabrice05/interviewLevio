package ca.levio.interview.messages;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;

public interface IMessageConsumer {
   public void readMessage(InterviewDto msg);
   public void readMessage(TechnicalAdvisorInterviewDto msg);
}
