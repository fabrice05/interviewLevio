package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.IJobPositionRepository;
import ca.levio.interview.db.repositories.ISkillRepository;
import ca.levio.interview.dtos.InterviewDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TechnicalAdvisorChekingService {
    final ISkillRepository skillRepository;
    final IJobPositionRepository jobPositionRepository;

    public TechnicalAdvisorChekingService( ISkillRepository skillRepository, IJobPositionRepository jobPositionRepository) {
        this.skillRepository = skillRepository;
        this.jobPositionRepository = jobPositionRepository;
    }

      List<Skill> getListSkillMatching(InterviewDto interview){
      // Same JobPosition with higth level
        List<Skill> listTechnical= skillRepository.findSkillByJobPosition_IdAndLevelOfExpertiseGreaterThan(interview.getJobPositionCandidateId(), interview.getLevelOfExpertiseCandidate());
        JobPosition actualJobPosition= jobPositionRepository.getReferenceById(interview.getJobPositionCandidateId());
     // find for JobParent
       if(listTechnical==null){
           listTechnical=new ArrayList<>();
       }
          UUID idparent=actualJobPosition.getId();
          while (actualJobPosition!=null && idparent!=null){
          idparent= jobPositionRepository.getJobPositionParentId(idparent);
           if(idparent!=null){
               actualJobPosition=   jobPositionRepository.getReferenceById(idparent);
               List<Skill> listTechnicalParent=skillRepository.findSkillByJobPosition_Id(actualJobPosition.getId());
               if(listTechnicalParent!=null){
                   listTechnical.addAll(listTechnicalParent) ;
               }
           }
   }
    return listTechnical;
    }
}
