package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {
}