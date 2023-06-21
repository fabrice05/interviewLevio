package ca.levio.interview.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

public interface INotificationMail {
   public void sendEmail(String message, String destinataire[], String copy[], String subject);
    public void sendEmail(String message, String destinataire, String copy, String subject);
}
