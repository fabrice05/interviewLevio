package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorSkillRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TechnicalAdvisorCheking {
    final TechnicalAdvisorSkillRepository repository;
    final  JobPositionRepository jobPositionRepository;
    public TechnicalAdvisorCheking(TechnicalAdvisorSkillRepository repository, JobPositionRepository jobPositionRepository) {
        this.repository = repository;
        this.jobPositionRepository = jobPositionRepository;
    }
    private List<TechnicalAdvisorAndSkill> getListTechnicalAdvisor(Interview interview) {
    //private List<TechnicalAdvisorAndSkill> getListTechnicalAdvisor(String name, LevelOfExpertise level) {
        //List of Job position by the current Title Job of candidate
        JobPosition actualJobPositionSon =jobPositionRepository.findByName(interview.getJobPosition());
        List<TechnicalAdvisorAndSkill> setOfTechnicalAdvisor=new ArrayList<>();
           if(actualJobPositionSon!=null) {
               JobPosition actualJobPositionParent = actualJobPositionSon.getJobPosition();
               while (actualJobPositionParent != null) {
                   setOfTechnicalAdvisor.addAll(repository.findByjobPositionId(actualJobPositionParent.getId()));
                   actualJobPositionParent = actualJobPositionParent.getJobPosition();
               }
               setOfTechnicalAdvisor.addAll(repository.findByJobNameAndLevelOfExpertiseGreaterThan(actualJobPositionSon.getName(), interview.getLevelOfExpertise()));
           }
        return setOfTechnicalAdvisor;
    }
        public List<TechnicalAdvisorAndSkill> getAll() {
            return repository.findAll();
        }

    public List<TechnicalAdvisorAndSkill> getSameTechnicalWithHigthLevel(String jobName, LevelOfExpertise levelOfExpertise) {
        return repository.findByJobNameAndLevelOfExpertiseGreaterThan(jobName, levelOfExpertise);
    }


    public void createTechnicalChoise(Interview interview) {
        List<TechnicalAdvisorAndSkill> setTechnical=getListTechnicalAdvisor(interview);
      setTechnical.forEach(tech->
              {
                  SkillInterview skillInterview=new SkillInterview("OPEN",
                          interview,new JobPosition(tech.getJobPositionId()));
              });
    }
}
