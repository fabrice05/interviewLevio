package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobPositionRepository extends JpaRepository<JobPosition, UUID> {
    JobPosition findByName(String name);
}