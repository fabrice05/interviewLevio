package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.LineOfBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineOfBusinessRepository extends JpaRepository<LineOfBusiness, Integer> {
}