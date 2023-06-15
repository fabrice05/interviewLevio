package ca.levio.interview.db.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "interview")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;


    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @Column(name = "interviewtype", length = 10) //Interne or Externe
    private String interviewType;
    @Column(name = "isurgent")
    private Boolean isUrgent;

    @Column(name = "interview_status", nullable = false, length = 20)
    private String interviewStatus;

//  Candidate Information
    @Column(name = "candidate_full_name", nullable = false, length = 200)
    private String CandidateName;
    @Column(name = "jobposition", length = 100)
    private String jobPosition;

    @Column(name = "level_of_expertise",nullable = false)
    private LevelOfExpertise levelOfExpertise;

//  Recruiter Information

    @Column(name = "Recruiter_full_name", nullable = false, length = 150)
    private String recruiterName;

    @Column(name = "recruiter_email", length = 100)
    private String recruiterEmail;

    @OneToMany(mappedBy = "interview", orphanRemoval = true)
    private Collection<SkillInterview> skillInterviews = new ArrayList<>();

    public Collection<SkillInterview> getSkillInterviews() {
        return skillInterviews;
    }

    public void setSkillInterviews(Collection<SkillInterview> skillInterviews) {
        this.skillInterviews = skillInterviews;
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

    public Boolean getUrgent() {
        return isUrgent;
    }

    public void setUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(LevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }
}
