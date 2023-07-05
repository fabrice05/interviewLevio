package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.ELevelOfExpertise;
import ca.levio.interview.db.entities.Skill;
import ca.levio.interview.db.entities.ViewTechnicalAdvisorAndSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ISkillRepository extends JpaRepository< Skill, UUID> {
    //List<ViewTechnicalAdvisorAndSkill>  findByJobNameAndLevelOfExpertiseGreaterThan(String job_Name, ELevelOfExpertise level);
    List<ViewTechnicalAdvisorAndSkill>  findByjobPositionId(UUID id);
}