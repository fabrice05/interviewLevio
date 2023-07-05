package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.ELevelOfExpertise;
import jakarta.validation.constraints.*;

import java.util.UUID;

public class InterviewDto {
    private UUID id;
    @NotNull
    private String description;
    @NotNull
    //Interne or Externe
    private String interviewType;
    private boolean urgent;
    private String interviewStatus;
    private String CandidateName;
    private String jobPosition;
    private ELevelOfExpertise levelOfExpertiseCandidate;
    private String recruiterName;
    private String recruiterEmail;

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

    public ELevelOfExpertise getLevelOfExpertiseCandidate() {
        return levelOfExpertiseCandidate;
    }

    public void setLevelOfExpertiseCandidate(ELevelOfExpertise levelOfExpertiseCandidate) {
        this.levelOfExpertiseCandidate = levelOfExpertiseCandidate;
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
        return "InterviewDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", Urgent=" + urgent +
                ", interviewStatus='" + interviewStatus + '\'' +
                ", CandidateName='" + CandidateName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", levelOfExpertise=" + levelOfExpertiseCandidate +
                ", recruiterName='" + recruiterName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                '}';
    }
}
