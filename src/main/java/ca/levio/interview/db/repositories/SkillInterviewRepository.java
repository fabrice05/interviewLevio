package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.SkillInterview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillInterviewRepository extends JpaRepository<SkillInterview, Integer> {
}