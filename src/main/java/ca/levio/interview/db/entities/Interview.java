package ca.levio.interview.db.entities;


import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import ca.levio.interview.db.entities.Enum.InterviewStatus;
import ca.levio.interview.db.entities.Enum.InterviewType;
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

    @Column(name = "interview_type") //Interne or Externe
    private InterviewType interviewType;
    @Column(name = "urgent")
    private boolean urgent;

    @Column(name = "interview_status")  // OPEN   //CLOSE
    private InterviewStatus interviewStatus;

//  Candidate Information
    @Column(name = "candidate_full_name", nullable = false, length = 200)
    private String candidateName;
    @Column(name = "job_position_candidate")
    private UUID jobPositionCandidateId;

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

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
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

    public UUID getJobPositionCandidateId() {
        return jobPositionCandidateId;
    }

    public void setJobPositionCandidateId(UUID jobPositionCandidateId) {
        this.jobPositionCandidateId = jobPositionCandidateId;
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
                ", jobPosition='" + jobPositionCandidateId + '\'' +
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

