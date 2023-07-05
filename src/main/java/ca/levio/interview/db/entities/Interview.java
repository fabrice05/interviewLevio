package ca.levio.interview.db.entities;


import jakarta.persistence.*;

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

    @Column(name = "interview_type", length = 10) //Interne or Externe
    private String interviewType;
    @Column(name = "urgent")
    private boolean urgent;

    @Column(name = "interview_status", nullable = false, length = 20)
    private String interviewStatus;

//  Candidate Information
    @Column(name = "candidate_full_name", nullable = false, length = 200)
    private String candidateName;
    @Column(name = "job_position_candidate", length = 100)
    private String jobPosition;

    @Column(name = "level_of_expertise_candidate",nullable = false)
    private ELevelOfExpertise levelOfExpertiseCandidate;

//  Recruiter Information

    @Column(name = "recruiter_full_name", nullable = false, length = 150)
    private String recruiterName;

    @Column(name = "recruiter_email", length = 100)
    private String recruiterEmail;

    @OneToMany(mappedBy = "interview", orphanRemoval = true)
    private Collection<TechnicalAdvisorInterview> technicalAdvisorInterviews = new ArrayList<>();

    public Collection<TechnicalAdvisorInterview> getTechnicalAdvisorInterviews() {
        return technicalAdvisorInterviews;
    }

    public void setTechnicalAdvisorInterviews(Collection<TechnicalAdvisorInterview> technicalAdvisorInterviews) {
        this.technicalAdvisorInterviews = technicalAdvisorInterviews;
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

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public ELevelOfExpertise getLevelOfExpertiseCandidate() {
        return levelOfExpertiseCandidate;
    }

    public void setLevelOfExpertiseCandidate(ELevelOfExpertise levelOfExpertiseCandidate) {
        this.levelOfExpertiseCandidate = levelOfExpertiseCandidate;
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
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
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

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", urgent=" + urgent +
                ", interviewStatus='" + interviewStatus + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", levelOfExpertise=" + levelOfExpertiseCandidate +
                ", recruiterName='" + recruiterName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                ", skillInterviews=" + technicalAdvisorInterviews +
                '}';
    }

    public Interview() {
    }

    public Interview(UUID id) {
        this.id = id;
    }

}

