package ca.levio.interview.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//Todo : nommage
public interface INotificationMail {
    //Todo : est-ce vraiment nécessaire d'avoir ces 2 signatures ?
    //Todo : attention à la manière dont tu déclares les tableaux
    //Todo : Puisque tu fais ces 2, pourquoi ne pas faire aussi les combinaisons "String[] destinataire, String copy" et "String destinataire, String[] copy"
    //Une seule signature serait suffisante, où à la rigueur si tu veux vriament en faire plusieurs prévois des
    // implémentations par défaut pour les autres parce que là tu compliques la vie des classes qui vont implémenter ton interface
   public void sendEmail(String message, String destinataire[], String copy[], String subject);
    public void sendEmail(String message, String destinataire, String copy, String subject);
}
