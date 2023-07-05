package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IInterviewRepository extends JpaRepository<Interview, UUID>{
}