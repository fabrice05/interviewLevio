package ca.levio.interview.db.repositories;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.entities.ViewTechnicalAdvisorAndSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IViewTechnicalAdvisorAndSkillRepository extends JpaRepository<ViewTechnicalAdvisorAndSkill, UUID>{

}