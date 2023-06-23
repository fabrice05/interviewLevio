package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorSkillRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
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
    private Set<TechnicalAdvisorAndSkill> getListTechnicalAdvisor(String name, LevelOfExpertise level) {
        //List of Job position by the current Title Job of candidate
        List<JobPosition> listOfActualJobPosition =jobPositionRepository.findByName(name);
        Set<TechnicalAdvisorAndSkill> setOfTechnicalAdvisor=new HashSet<>();

        listOfActualJobPosition.forEach(actualJobPositionSon->{
            JobPosition actualJobPositionParent = actualJobPositionSon.getJobPosition();
            while (actualJobPositionParent!=null && actualJobPositionParent.getId()!=null){
                setOfTechnicalAdvisor.addAll(repository.findByjobPositionId(actualJobPositionParent.getId()));
                actualJobPositionParent = actualJobPositionParent.getJobPosition();
            }
            setOfTechnicalAdvisor.addAll(repository.findByJobNameAndLevelOfExpertiseGreaterThan(actualJobPositionSon.getName(),level));
        });
        return setOfTechnicalAdvisor;
    }
        public List<TechnicalAdvisorAndSkill> getAll() {
            return repository.findAll();
        }

    public List<TechnicalAdvisorAndSkill> getSameTechnicalWithHigthLevel(String jobName, LevelOfExpertise levelOfExpertise) {
        return repository.findByJobNameAndLevelOfExpertiseGreaterThan(jobName, levelOfExpertise);
    }


    public void createTechnicalChoise(Interview elementJpa) {
        Set<TechnicalAdvisorAndSkill> setTechnical=getListTechnicalAdvisor(elementJpa.getJobPosition(),elementJpa.getLevelOfExpertise());
      setTechnical.forEach(tech->
              {
                  SkillInterview skillInterview=new SkillInterview("OPEN",
                          elementJpa,new JobPosition(tech.getJobPositionId()));
              });
    }
}
