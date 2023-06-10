package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.TechnicalAdvisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalAdvisorRepository extends JpaRepository<TechnicalAdvisor, Integer> {
}