package ca.levio.interview.services;

public interface INotificationMessage {
  // public void sendEmail(String message, String[] destinataire, String[] copy, String subject);
    public void sendEmail(String message, String destinataire, String copy, String subject);
}
