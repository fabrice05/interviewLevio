package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.entities.Enum.TechnicalInterviewStatus;
import ca.levio.interview.db.repositories.*;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;
import ca.levio.interview.messages.IMessageProducer;
import ca.levio.interview.services.INotificationMessage;
import ca.levio.interview.services.Impl.Dto.DtoAndEntityConversionExtension;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InterviewProcessService //implements IInterviewProcess
{
    private final TechnicalAdvisorChekingService technicalChecking;
    private final IInterviewRepository interviewRepository;
    private final ITechnicalAdvisorInterviewRepository technicalAdvisorInterviewRepository;
    private  final IMessageProducer messageProducer;
    private final INotificationMessage mail;


    @Value("${interview_MAX_NUMBER_TECHNICAL_SEND_BY_CYCLE}")
    private int maxNumber;
    @Value("${server_link}")
    private String serverLink;

    public InterviewProcessService(TechnicalAdvisorChekingService technical, IInterviewRepository interviewRepository, ITechnicalAdvisorInterviewRepository technicalAdvisorInterviewRepository, IMessageProducer messageProducer, INotificationMessage mail) {
        this.technicalChecking = technical;
        this.interviewRepository = interviewRepository;
        this.technicalAdvisorInterviewRepository = technicalAdvisorInterviewRepository;
        this.messageProducer = messageProducer;
        this.mail = mail;
    }
      public List<TechnicalAdvisorInterview> createTechnicalInterview(InterviewDto interviewDto){
         List<TechnicalAdvisorInterview> technicalAdvisorInterviewList=new ArrayList<>();
           List<Skill> technicalMatching = technicalChecking.getListSkillMatching(interviewDto);
          technicalMatching.forEach(elt->{
               Interview interview=  interviewRepository.getReferenceById(interviewDto.getId());
               TechnicalAdvisor technical = elt.getTechnicalAdvisor();
               TechnicalAdvisorInterview tai=new TechnicalAdvisorInterview(TechnicalInterviewStatus.OPEN,interview,technical);
              tai=technicalAdvisorInterviewRepository.save(tai);
              technicalAdvisorInterviewList.add(tai);
           });
          firsSelectTechnical(technicalAdvisorInterviewList);
        return technicalAdvisorInterviewList;
         }
    public void firsSelectTechnical(List<TechnicalAdvisorInterview> listTechnical){
       for(int i=0;i<maxNumber;i++){
           TechnicalAdvisorInterview technicalAdvisorInterview=  listTechnical.get(i);
           messageProducer.writeMessage(DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisorInterview));
       }
    }

    public void sendInvitationTechnical(TechnicalAdvisorInterviewDto msg) {
        //notified technical and modified TechnicalAdvisorInterviewDto to Invited
        TechnicalAdvisorInterview tech=technicalAdvisorInterviewRepository.getReferenceById(msg.getId());
        TechnicalAdvisor technicalAdvisor=technicalAdvisorInterviewRepository.findTechnicalAdvisor(msg.getId());
        Interview interview=technicalAdvisorInterviewRepository.findInterview(msg.getId());
        NotificationMessagingDto messages=new NotificationMessagingDto();
        messages.setCandidatejobPosition(interview.getLevelOfExpertiseCandidate().name());
        messages.setServerLink(serverLink);
        messages.setRecruiterEmail(interview.getRecruiterEmail());
        messages.setTechnicalAdvisorEmail(technicalAdvisor.getEmail());
        messages.setTechnicalAdvisorName(technicalAdvisor.getName());
        messages.setTechnicalAdvisorIntervewId(msg.getId());
        try {
            mail.sendHtmlMessageCandidate("sendMailNotification",messages);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
     tech.setStatus(TechnicalInterviewStatus.INVITED);
        technicalAdvisorInterviewRepository.saveAndFlush(tech);

    }
}
