package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.LineOfBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ILineOfBusinessRepository extends JpaRepository<LineOfBusiness, UUID>{
}