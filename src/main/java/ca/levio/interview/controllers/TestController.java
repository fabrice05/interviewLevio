package ca.levio.interview.controllers;

import ca.levio.interview.dtos.NotificationMessagingDto;

import ca.levio.interview.messages.MessageProducer;
import ca.levio.interview.services.INotificationMail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private  final MessageProducer producer;
    private INotificationMail mail;

    public TestController(MessageProducer producer, INotificationMail mail) {
        this.producer = producer;
        this.mail = mail;
    }
    @PostMapping("/api/publish")
    public void writeMessage(@RequestBody NotificationMessagingDto notification){
        this.producer.writeMessage(notification);
    }

    @PostMapping("/api/message")
    public String sendMessage(@RequestBody NotificationMessagingDto notification){

        mail.sendEmail(notification.getMessage(),new String[]{"fabrice.ngadjeu@gmail.com"},null,"Ceci est un test de Message");
       return "Processus d'envoie de Message en Cours...";
    }
}
