package ca.levio.interview.messages;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;

public interface IMessageProducer {
    public void writeMessage(InterviewDto msg);
    public void writeMessage(TechnicalAdvisorInterviewDto msg);
}
