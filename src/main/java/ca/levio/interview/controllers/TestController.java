package ca.levio.interview.controllers;

import ca.levio.interview.dtos.NotificationDto;
import ca.levio.interview.messages.KafkaProducer;
import ca.levio.interview.services.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private  final KafkaProducer kafkaProducer;
    private NotificationService notificationService;

    public TestController(KafkaProducer kafkaProducer, NotificationService notificationService) {
        this.kafkaProducer = kafkaProducer;
        this.notificationService = notificationService;
    }
    @PostMapping("/api/publish")
    public void WriteMessage(@RequestParam("message") String message){
        this.kafkaProducer.WriteMessage(message);
    }

    @PostMapping("/api/message")
    public String sendMessage(@RequestBody NotificationDto notification){

       notificationService.sendEmail(notification.getMessage(),new String[]{"fabrice.ngadjeu@gmail.com"},null,"Ceci est un test de Message");
       return "Processus d'envoie de Message en Cours...";
    }
}
