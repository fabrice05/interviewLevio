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
        //Todo : passer par les noms est très dangereux (faute de frappe, ...) on avait évoqué le fait d'utiliser la clé du job plutot que son nom)
        //En plus je ne comprends pas, à partir du nom tu dois en trouver un seul, alors pourquoi une liste ???
        List<JobPosition> listOfActualJobPosition =jobPositionRepository.findByName(name);
        //Todo : pourquoi un set ?
        Set<TechnicalAdvisorAndSkill> setOfTechnicalAdvisor=new HashSet<>();

        listOfActualJobPosition.forEach(actualJobPositionSon->{
            JobPosition actualJobPositionParent = actualJobPositionSon.getJobPosition();
            //Todo : comment l'id pourrait etre null ?
            while (actualJobPositionParent!=null && actualJobPositionParent.getId()!=null){
                //Todo : tu ajoutes une list dans un set, il va se passser quoi à ton avis ? As-tu testé ?
                setOfTechnicalAdvisor.addAll(repository.findByjobPositionId(actualJobPositionParent.getId()));
                actualJobPositionParent = actualJobPositionParent.getJobPosition();
            }
            //Todo : tu ajoutes une list dans un set, il va se passser quoi à ton avis ? As-tu testé ?
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


    //Todo : elementJpa te semble etre un bon nom de variable ?
    public void createTechnicalChoise(Interview elementJpa) {
        Set<TechnicalAdvisorAndSkill> setTechnical=getListTechnicalAdvisor(elementJpa.getJobPosition(),elementJpa.getLevelOfExpertise());
      setTechnical.forEach(tech->
              {
                  SkillInterview skillInterview=new SkillInterview("OPEN",
                          elementJpa,new JobPosition(tech.getJobPositionId()));
              });
    }
}
