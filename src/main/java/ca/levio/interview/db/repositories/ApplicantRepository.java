package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}