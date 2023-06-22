package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkillRepository extends JpaRepository<Skill, UUID> {
}