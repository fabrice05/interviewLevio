package ca.levio.interview.dtos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class NotificationMessagingDto {
    @NotEmpty
    private String message;
    @NotNull
    //Todo : mélange francais anglais
    private String destinataire;
    private String copy;
    @NotNull
    private String subject;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "NotificationMessagingDto{" +
                "message='" + message + '\'' +
                ", destinataire='" + destinataire + '\'' +
                ", copy='" + copy + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
