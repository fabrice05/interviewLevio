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
    public void sendHtmlMessage(String template, NotificationMessagingDto messaging, UUID skillInterViewTechnicalId) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariable("msg",messaging);
        context.setVariable("skill_id",skillInterViewTechnicalId);

        helper.setFrom(messaging.getRecruiterEmail());
        helper.setTo(messaging.getTechnicalAdvisorEmail());
        helper.setSubject(messaging.getCandidatejobPosition());
        String html = templateEngine.process(template, context);
        helper.setText(html, true);
        javaMailSender.send(message);
    }
}
