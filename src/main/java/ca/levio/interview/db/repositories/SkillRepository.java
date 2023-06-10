package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}