package ca.levio.interview.services.Impl;

import ca.levio.interview.services.INotificationMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;

@Service
public class NotificationService implements INotificationMessage {
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

    @Async
    public void sendHtmlMessage() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        /*context.setVariables(email.getProperties());
        helper.setFrom(email.getFrom());
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        String html = templateEngine.process(email.getTemplate(), context);
        helper.setText(html, true);

        log.info("Sending email: {} with html body: {}", email, html);
        emailSender.send(message);*/
    }
}
