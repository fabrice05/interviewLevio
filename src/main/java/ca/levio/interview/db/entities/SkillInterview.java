package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "skill_interview")
public class SkillInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "date_of_demand")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date dateOfDemande;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Date getDateOfDemande() {
        return dateOfDemande;
    }

    public void setDateOfDemande(Date dateOfDemande) {
        this.dateOfDemande = dateOfDemande;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
