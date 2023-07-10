package ca.levio.interview.services.Impl;

import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.services.INotificationMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class NotificationService implements INotificationMessage {
    private JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    public NotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
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
    @Override
    public void sendHtmlMessageCandidate(String template, NotificationMessagingDto msg) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariable("msg",msg);

        helper.setFrom(msg.getRecruiterEmail());
        helper.setTo(msg.getTechnicalAdvisorEmail());
        helper.setSubject("Demande d'interview pour un poste de :"+msg.getCandidatejobPosition());
        String html = templateEngine.process(template, context);
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
