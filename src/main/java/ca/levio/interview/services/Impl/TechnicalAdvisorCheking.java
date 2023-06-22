package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.LevelOfExpertise;
import ca.levio.interview.db.entities.TechnicalAdvisorAndSkill;
import ca.levio.interview.db.repositories.JobPositionRepository;
import ca.levio.interview.db.repositories.TechnicalAdvisorSkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TechnicalAdvisorCheking {
    final TechnicalAdvisorSkillRepository repository;
    final  JobPositionRepository jobPositionRepository;
    public TechnicalAdvisorCheking(TechnicalAdvisorSkillRepository repository, JobPositionRepository jobPositionRepository) {
        this.repository = repository;
        this.jobPositionRepository = jobPositionRepository;
    }
    private List<UUID> getListAllJobPositionAndParent(String name) {
        JobPosition actualJobPosition =jobPositionRepository.findByName(name);
        UUID parent_id=null;


        if(actualJobPosition!=null){
            parent_id=actualJobPosition.getJobPosition().getId();
        }
        while (parent_id!=null){


        }
        List<JobPosition> listParent=new ArrayList<>();

        return null;

    }
        public List<TechnicalAdvisorAndSkill> getAll() {
            return repository.findAll();
        }

    public List<TechnicalAdvisorAndSkill> getSameTechnicalWithHigthLevel(String jobName, LevelOfExpertise levelOfExpertise) {
        return repository.findByJobNameAndLevelOfExpertiseGreaterThan(jobName, levelOfExpertise);
    }



}
