package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import ca.levio.interview.db.entities.Enum.InterviewStatus;
import ca.levio.interview.db.entities.Enum.InterviewType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.UUID;

public class InterviewDto implements Serializable {
    private UUID id;
    @NotNull
    private String description;
    @NotNull
    //Interne or Externe
    private InterviewType interviewType;
    private boolean urgent;
    private InterviewStatus interviewStatus;
    private String CandidateName;
    private UUID jobPositionCandidateId;
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

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public UUID getJobPositionCandidateId() {
        return jobPositionCandidateId;
    }

    public void setJobPositionCandidateId(UUID jobPositionCandidateId) {
        this.jobPositionCandidateId = jobPositionCandidateId;
    }

    public ELevelOfExpertise getLevelOfExpertiseCandidate() {
        return levelOfExpertiseCandidate;
    }

    public void setLevelOfExpertiseCandidate(ELevelOfExpertise levelOfExpertiseCandidate) {
        this.levelOfExpertiseCandidate = levelOfExpertiseCandidate;
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
                ", jobPosition='" + jobPositionCandidateId + '\'' +
                ", levelOfExpertise=" + levelOfExpertiseCandidate +
                ", recruiterName='" + recruiterName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                '}';
    }
}
