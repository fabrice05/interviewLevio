package ca.levio.interview.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ShedulingTask {

    @Scheduled(fixedDelay = 1000*60*10)
    public void VerifiedInvitationSendInterview() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedDelay = 1000*60*60)
    public void VerifiedInvitationStatusAndNotifiedNotAnswer() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }
}
