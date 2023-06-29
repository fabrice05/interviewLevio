package ca.levio.interview.services;

import ca.levio.interview.dtos.NotificationMessagingDto;
import jakarta.mail.MessagingException;

import java.util.UUID;

public interface INotificationMessage {
  // public void sendEmail(String message, String[] destinataire, String[] copy, String subject);
    public void sendEmail(String message, String destinataire, String copy, String subject);

  public void sendHtmlMessage(String template, NotificationMessagingDto messaging, UUID skillInterViewTechnicalId)throws MessagingException;
}
