package ca.levio.interview.db.repositories;

import ca.levio.interview.db.entities.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IJobPositionRepository extends JpaRepository< JobPosition, UUID>{
    public JobPosition findByName(String name);
    @Query("select j.jobPosition.id from job_position j where j.id= (:id)")
    public UUID getJobPositionParentId(@Param("id") UUID id);
}