package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.LevelOfExpertise;
import ca.levio.interview.db.entities.TechnicalAdvisorAndSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface TechnicalAdvisorSkillRepository extends JpaRepository<TechnicalAdvisorAndSkill,UUID> {
    List<TechnicalAdvisorAndSkill>  findByJobNameAndLevelOfExpertiseGreaterThan(String job_Name, LevelOfExpertise level);
    List<TechnicalAdvisorAndSkill>  findByjobPositionId(UUID id);
}