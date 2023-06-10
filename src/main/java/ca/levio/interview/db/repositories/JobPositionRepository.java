package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {
}