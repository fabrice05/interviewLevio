package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "levelofexpertise", nullable = false)
    private LevelOfExpertise levelOfExpertise;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
    @ManyToOne
    @JoinColumn(name = "technical_advisor_id")
    private TechnicalAdvisor technicalAdvisor;

    @OneToMany(mappedBy = "skill", orphanRemoval = true)
    private Collection<SkillInterview> skillInterviews = new ArrayList<>();

    public Collection<SkillInterview> getSkillInterviews() {
        return skillInterviews;
    }

    public void setSkillInterviews(Collection<SkillInterview> skillInterviews) {
        this.skillInterviews = skillInterviews;
    }

    public TechnicalAdvisor getTechnicalAdvisor() {
        return technicalAdvisor;
    }

    public void setTechnicalAdvisor(TechnicalAdvisor technicalAdvisor) {
        this.technicalAdvisor = technicalAdvisor;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(LevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
