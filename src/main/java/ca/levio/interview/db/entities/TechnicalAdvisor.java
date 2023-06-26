package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "technicaladvisor")
public class TechnicalAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "levelofexpertise", nullable = false)
    private LevelOfExpertise levelOfExpertise;
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "actif")
    private Boolean isActif;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPosition;
    @OneToMany(mappedBy = "technicalAdvisor", orphanRemoval = true)
    private Collection<SkillInterview> skills = new ArrayList<>();

    public Collection<SkillInterview> getSkills() {
        return skills;
    }

    public void setSkills(Collection<SkillInterview> skills) {
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActif() {
        return isActif;
    }

    public void setActif(Boolean actif) {
        isActif = actif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public LevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(LevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TechnicalAdvisor() {
    }

    public TechnicalAdvisor(UUID id) {
        this.id = id;
    }
}
