package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.IJobPositionRepository;
import ca.levio.interview.db.repositories.ISkillRepository;
import ca.levio.interview.db.repositories.IViewTechnicalAdvisorAndSkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnicalAdvisorChekingService {
    final ISkillRepository repository;
    final IViewTechnicalAdvisorAndSkillRepository viewTechnicalAdvisorAndSkill;
    final IJobPositionRepository jobPositionRepository;
    public TechnicalAdvisorChekingService(ISkillRepository repository, IViewTechnicalAdvisorAndSkillRepository viewTechnicalAdvisorAndSkill, IJobPositionRepository jobPositionRepository) {
        this.repository = repository;
        this.viewTechnicalAdvisorAndSkill = viewTechnicalAdvisorAndSkill;
        this.jobPositionRepository = jobPositionRepository;
    }
    public List<ViewTechnicalAdvisorAndSkill> getListTechnicalAdvisor(Interview interview) {
    //private List<TechnicalAdvisorAndSkill> getListTechnicalAdvisor(String name, LevelOfExpertise level) {
        //List of Job position by the current Title Job of candidate
        JobPosition actualJobPositionSon =jobPositionRepository.findByName(interview.getJobPosition());
        List<ViewTechnicalAdvisorAndSkill> setOfTechnicalAdvisor=new ArrayList<>();
           if(actualJobPositionSon!=null) {
               JobPosition actualJobPositionParent = actualJobPositionSon.getJobPosition();
               while (actualJobPositionParent != null) {
                   setOfTechnicalAdvisor.addAll(repository.findByjobPositionId(actualJobPositionParent.getId()));
                   actualJobPositionParent = actualJobPositionParent.getJobPosition();
               }
               //setOfTechnicalAdvisor.addAll(repository.findByJobNameAndLevelOfExpertiseGreaterThan(actualJobPositionSon.getName(), interview.getLevelOfExpertise()));
           }
        return setOfTechnicalAdvisor;
    }
        public List<ViewTechnicalAdvisorAndSkill> getAll() {
            return viewTechnicalAdvisorAndSkill.findAll();
        }

    public List<ViewTechnicalAdvisorAndSkill> getSameTechnicalWithHigthLevel(String jobName, ELevelOfExpertise levelOfExpertise) {
       // return repository.findByJobNameAndLevelOfExpertiseGreaterThan(jobName, levelOfExpertise);
        return null;
    }



}
