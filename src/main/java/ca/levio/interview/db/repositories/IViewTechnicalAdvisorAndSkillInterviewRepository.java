package ca.levio.interview.db.repositories;
import ca.levio.interview.db.entities.ViewTechnicalAdvisorAndSkillInterview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IViewTechnicalAdvisorAndSkillInterviewRepository extends JpaRepository<ViewTechnicalAdvisorAndSkillInterview, UUID>{

}