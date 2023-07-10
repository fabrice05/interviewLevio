package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import ca.levio.interview.db.entities.ViewTechnicalAdvisorAndSkillInterview;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;

import ca.levio.interview.messages.IMessageProducer;
import ca.levio.interview.services.INotificationMessage;
import ca.levio.interview.services.Impl.TechnicalAdvisorChekingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private  final IMessageProducer producer;
    private  final TechnicalAdvisorChekingService checking;
    private INotificationMessage mail;

    public TestController(IMessageProducer producer, TechnicalAdvisorChekingService checking, INotificationMessage mail) {
        this.producer = producer;
        this.checking = checking;
        this.mail = mail;
    }
    @PostMapping("/api/publish")
    public void writeMessage(@RequestBody InterviewDto notification){
        this.producer.writeMessage(notification);
    }


    @GetMapping("/api/same")
    public String TechnicalSame(){
      /*  for (ViewTechnicalAdvisorAndSkillInterview technicalAdvisorAndSkill : checking.getSameTechnicalWithHigthLevel("Développeur Java", ELevelOfExpertise.JUNIOR)) {
            System.out.println(technicalAdvisorAndSkill);
        }
    */
        return "Processus d'envoie de Message en Cours...";
    }
}
