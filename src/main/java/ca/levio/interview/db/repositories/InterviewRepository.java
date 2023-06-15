package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.Interview;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface InterviewRepository extends JpaRepository<Interview,UUID> {
}