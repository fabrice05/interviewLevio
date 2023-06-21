package ca.levio.interview.services.Impl;

import ca.levio.interview.services.INotificationMail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationMail {
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
    @Override
    @Async
    public void sendEmail(String message, String destinataire, String copy, String subject) {
        sendEmail(message,new String[]{destinataire},new String[]{copy},subject);
    }
}
