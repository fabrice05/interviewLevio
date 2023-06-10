package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {
}