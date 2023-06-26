package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "skill_interview")
public class SkillInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "status", nullable = false, length = 250)
    private String status;
    @CreationTimestamp
    @JdbcTypeCode(SqlTypes.DATE)
    private Date createdAt;

    @UpdateTimestamp
    @JdbcTypeCode(SqlTypes.DATE)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;
    @ManyToOne
    @JoinColumn(name = "technical_advisor_id")
    private TechnicalAdvisor technicalAdvisor;
    @Column(name = "technical_preselectionne", nullable = true)
    private Boolean firstChoiceTechnical;
    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public SkillInterview() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getFirstChoiceTechnical() {
        return firstChoiceTechnical;
    }

    public void setFirstChoiceTechnical(Boolean firstChoiceTechnical) {
        this.firstChoiceTechnical = firstChoiceTechnical;
    }

    public SkillInterview(String status, Interview interview, JobPosition jobPosition) {
        this.status = status;
        this.interview = interview;
        this.jobPosition = jobPosition;
    }
}
