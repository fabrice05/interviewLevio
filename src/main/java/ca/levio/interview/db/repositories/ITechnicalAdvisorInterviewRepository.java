package ca.levio.interview.db.repositories;
import ca.levio.interview.db.entities.TechnicalAdvisorInterview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITechnicalAdvisorInterviewRepository extends JpaRepository<TechnicalAdvisorInterview, UUID>{

}