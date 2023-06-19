package ca.levio.interview.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
 @Async
   public void sendEmail(String message, String destinataire[], String copy[], String subject) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(destinataire);
        msg.setBcc(copy);

        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
    }
}
