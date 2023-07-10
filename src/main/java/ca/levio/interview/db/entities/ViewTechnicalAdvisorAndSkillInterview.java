package ca.levio.interview.db.entities;


import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Subselect;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.Immutable;

import java.sql.Date;
import java.util.UUID;

@Entity()
@Immutable
@Subselect("select * from technical_advisor_skill_interview")
public class ViewTechnicalAdvisorAndSkillInterview {
    @Id
    @Column(name = "technical_advisor_interview_id")
    private UUID technicalAdvisorInterviewId;
    @Column(name = "status")
    private String technicalInterviewStatus;
    @Column(name = "created_at")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date createdAt;
    @Column(name = "updated_at")
    @JdbcTypeCode(SqlTypes.DATE)
    private Date updatedAt;

    @Column(name = "interview_id")
    private UUID interviewId;
    @Column(name = "technical_advisor_id")
    private UUID technicalAdvisorId;
    @Column(name = "technical_default_select")
    private boolean firstChoiceTechnical;
    @Column(name = "technical_advisor_name")
    private String technicalAdvisorName;
    @Column(name = "technical_advisor_email")
    private String technicalAdvisorEmail;
    @Column(name = "technical_advisor_activ")
    private boolean technicalAdvisorActiv;
    @Column(name = "job_position_candidate")
    private UUID jobPositionCandidateId;
    @Column(name = "level_of_expertise_candidate")
    private ELevelOfExpertise levelOfExpertise;
    @Column(name = "description")
    private String description;

    @Column(name = "interview_type")
    private String interviewType;

    @Column(name = "candidate_full_name")
    private String candidateFullName;

    @Column(name = "interview_status")
    private String interviewStatus;

    @Column(name = "recruiter_email")
    private String recruiterEmail;
    @Column(name = "urgent", nullable = true)
    private boolean urgent;

    public UUID getTechnicalAdvisorInterviewId() {
        return technicalAdvisorInterviewId;
    }

    public void setTechnicalAdvisorInterviewId(UUID technicalAdvisorInterviewId) {
        this.technicalAdvisorInterviewId = technicalAdvisorInterviewId;
    }

    public String getTechnicalInterviewStatus() {
        return technicalInterviewStatus;
    }

    public void setTechnicalInterviewStatus(String technicalInterviewStatus) {
        this.technicalInterviewStatus = technicalInterviewStatus;
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

    public UUID getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(UUID interviewId) {
        this.interviewId = interviewId;
    }

    public UUID getTechnicalAdvisorId() {
        return technicalAdvisorId;
    }

    public void setTechnicalAdvisorId(UUID technicalAdvisorId) {
        this.technicalAdvisorId = technicalAdvisorId;
    }

    public boolean isFirstChoiceTechnical() {
        return firstChoiceTechnical;
    }

    public void setFirstChoiceTechnical(boolean firstChoiceTechnical) {
        this.firstChoiceTechnical = firstChoiceTechnical;
    }

    public String getTechnicalAdvisorName() {
        return technicalAdvisorName;
    }

    public void setTechnicalAdvisorName(String technicalAdvisorName) {
        this.technicalAdvisorName = technicalAdvisorName;
    }

    public String getTechnicalAdvisorEmail() {
        return technicalAdvisorEmail;
    }

    public void setTechnicalAdvisorEmail(String technicalAdvisorEmail) {
        this.technicalAdvisorEmail = technicalAdvisorEmail;
    }

    public boolean isTechnicalAdvisorActiv() {
        return technicalAdvisorActiv;
    }

    public void setTechnicalAdvisorActiv(boolean technicalAdvisorActiv) {
        this.technicalAdvisorActiv = technicalAdvisorActiv;
    }

    public UUID getJobPositionCandidateId() {
        return jobPositionCandidateId;
    }

    public void setJobPositionCandidateId(UUID jobPositionCandidateId) {
        this.jobPositionCandidateId = jobPositionCandidateId;
    }

    public ELevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(ELevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getCandidateFullName() {
        return candidateFullName;
    }

    public void setCandidateFullName(String candidateFullName) {
        this.candidateFullName = candidateFullName;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }
}

