package ca.levio.interview.db.repositories;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.entities.TechnicalAdvisorInterview;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

public interface ITechnicalAdvisorInterviewRepository extends JpaRepository<TechnicalAdvisorInterview, UUID>{

    @Query("FROM technical_advisor_interview t where t.interview.id= (:idinterview)")
    List<TechnicalAdvisorInterview> lsitInterviewOpen(@Param("idinterview") UUID idInterview);

    @Query("select t.technicalAdvisor FROM technical_advisor_interview t where t.id= (:id)")
    TechnicalAdvisor findTechnicalAdvisor(@Param("id") UUID id);
    @Query("select t.interview FROM technical_advisor_interview t where t.id= (:id)")
    Interview findInterview(@Param("id") UUID id);
}