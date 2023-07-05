package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.ITechnicalAdvisorInterviewRepository;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;
import ca.levio.interview.services.IDecisionProcess;
import ca.levio.interview.services.IDtoAndEntityConversion;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DecisionProcessService implements IDecisionProcess {

    private final ITechnicalAdvisorInterviewRepository technicalAdvisorInterviewRepository;

    public DecisionProcessService(ITechnicalAdvisorInterviewRepository technicalAdvisorInterviewRepository) {

        this.technicalAdvisorInterviewRepository = technicalAdvisorInterviewRepository;
    }

    @Override
    public TechnicalAdvisorInterviewDto linkInterviewTechnicalAccept(UUID technicalAdvisorInterviewId) {
        TechnicalAdvisorInterview technicalAdvisorInterview=technicalAdvisorInterviewRepository.getReferenceById(technicalAdvisorInterviewId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        //TechnicalAdvisorInterview technicalAdvisorInterview = new TechnicalAdvisorInterview();
        // skillInterviewRepository.findSkillInterviewByInterview_IdAndFirstChoiceTechnical(skill.getInterview().getId(), true);
        if(technicalAdvisorInterview!=null){
            technicalAdvisorInterview.setFirstChoiceTechnical(true);
        }
        technicalAdvisorInterview.setStatus("ACCEPT");
        technicalAdvisorInterview = technicalAdvisorInterviewRepository.save(technicalAdvisorInterview);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisorInterview);
    }

    @Override
    public TechnicalAdvisorInterviewDto linkInterviewTechnicalReject(UUID skillId) {
        TechnicalAdvisorInterview technicalAdvisorInterview=technicalAdvisorInterviewRepository.getReferenceById(skillId);
        //si status <> OPEN, il y'a deja eu une prise de décision
        //si c'est la personne par defaut supprimer la liaison, voir si d'autres ont accepté et choisi un autre par défaut
        if(!technicalAdvisorInterview.getStatus().equals("OPEN")) // ENUM
        {
            if(technicalAdvisorInterview.getFirstChoiceTechnical()){
                technicalAdvisorInterview.setFirstChoiceTechnical(false);
            }

        } else{
            // Il y'a déjà eu prise de décision pour cette interview

        }
        technicalAdvisorInterview.setStatus("REJECT");

        technicalAdvisorInterview = technicalAdvisorInterviewRepository.save(technicalAdvisorInterview);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisorInterview);
    }
}
