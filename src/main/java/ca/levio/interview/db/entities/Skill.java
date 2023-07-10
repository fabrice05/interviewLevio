package ca.levio.interview.db.entities;


import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "level_of_expertise", nullable = false)
    private ELevelOfExpertise levelOfExpertise;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPosition;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "technical_advisor_id", nullable = false)
    private TechnicalAdvisor technicalAdvisor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ELevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(ELevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public TechnicalAdvisor getTechnicalAdvisor() {
        return technicalAdvisor;
    }

    public void setTechnicalAdvisor(TechnicalAdvisor technicalAdvisor) {
        this.technicalAdvisor = technicalAdvisor;
    }
}
