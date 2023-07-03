package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.SkillInterviewRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.NotificationMessagingDto;
import ca.levio.interview.dtos.SkillInterviewDto;
import ca.levio.interview.messages.MessageProducer;
import ca.levio.interview.services.IDecisionProcess;
import ca.levio.interview.services.IDtoAndEntityConversion;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DecisionProcessService implements IDecisionProcess {

    private final SkillInterviewRepository skillInterviewRepository;

    public DecisionProcessService(SkillInterviewRepository skillInterviewRepository) {

        this.skillInterviewRepository = skillInterviewRepository;
    }

    @Override
    public SkillInterviewDto linkInterviewTechnicalAccept(UUID skillId) {
        SkillInterview skill=skillInterviewRepository.getReferenceById(skillId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        skill.setStatus("ACCEPT");
        SkillInterview SkillReturn = skillInterviewRepository.save(skill);
        return IDtoAndEntityConversion.MAPPER.mapEntitytoDTO(SkillReturn);
    }

    @Override
    public SkillInterviewDto linkInterviewTechnicalReject(UUID skillId) {
        SkillInterview skill=skillInterviewRepository.getReferenceById(skillId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        //si c'est la personne par defaut supprimer la liaison, voir si d'autres ont accepté et choisi un autre par défaut
        if(!skill.getStatus().equals("OPEN")){
            if(skill.getFirstChoiceTechnical()){
                skill.setFirstChoiceTechnical(false);
            }
            skill.setStatus("REJECT");
        } else{
            // Il y'a déjà eu prise de décision pour cette interview

        }


        SkillInterview SkillReturn = skillInterviewRepository.save(skill);
        return IDtoAndEntityConversion.MAPPER.mapEntitytoDTO(SkillReturn);
    }
}
