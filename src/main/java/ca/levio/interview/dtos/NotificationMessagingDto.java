package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.LevelOfExpertise;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class NotificationMessagingDto {
    private  UUID jobPositionId;

    private String message;
    private String copy;

    private String subject;


    private UUID technicalAdvisorcanditateId;
    private String status="OPEN";
    private Boolean preselectedTechnicalAdvisor;
    private UUID interviewId;
    private String description;
    private String interviewType;
    private Boolean urgent;
    private String interviewStatus;
    private String candidateName;
    private String technicalAdvisorjobPosition;
    private LevelOfExpertise technicalAdvisorLevelOfExpertise;

    private String candidatejobPosition;
    private LevelOfExpertise candidateLevelOfExpertise;
    private String recruiterName;
    private String recruiterEmail;
    private String technicalAdvisorEmail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public UUID getTechnicalAdvisorcanditateId() {
        return technicalAdvisorcanditateId;
    }

    public void setTechnicalAdvisorcanditateId(UUID technicalAdvisorcanditateId) {
        this.technicalAdvisorcanditateId = technicalAdvisorcanditateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPreselectedTechnicalAdvisor() {
        return preselectedTechnicalAdvisor;
    }

    public void setPreselectedTechnicalAdvisor(Boolean preselectedTechnicalAdvisor) {
        this.preselectedTechnicalAdvisor = preselectedTechnicalAdvisor;
    }

    public UUID getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(UUID interviewId) {
        this.interviewId = interviewId;
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
        return urgent;
    }

    public void setUrgent(Boolean urgent) {
        this.urgent = urgent;
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

    public String getTechnicalAdvisorEmail() {
        return technicalAdvisorEmail;
    }

    public void setTechnicalAdvisorEmail(String technicalAdvisorEmail) {
        this.technicalAdvisorEmail = technicalAdvisorEmail;
    }

    public String getTechnicalAdvisorjobPosition() {
        return technicalAdvisorjobPosition;
    }

    public void setTechnicalAdvisorjobPosition(String technicalAdvisorjobPosition) {
        this.technicalAdvisorjobPosition = technicalAdvisorjobPosition;
    }

    public LevelOfExpertise getTechnicalAdvisorLevelOfExpertise() {
        return technicalAdvisorLevelOfExpertise;
    }

    public void setTechnicalAdvisorLevelOfExpertise(LevelOfExpertise technicalAdvisorLevelOfExpertise) {
        this.technicalAdvisorLevelOfExpertise = technicalAdvisorLevelOfExpertise;
    }

    public String getCandidatejobPosition() {
        return candidatejobPosition;
    }

    public void setCandidatejobPosition(String candidatejobPosition) {
        this.candidatejobPosition = candidatejobPosition;
    }

    public LevelOfExpertise getCandidateLevelOfExpertise() {
        return candidateLevelOfExpertise;
    }

    public void setCandidateLevelOfExpertise(LevelOfExpertise candidateLevelOfExpertise) {
        this.candidateLevelOfExpertise = candidateLevelOfExpertise;
    }

    public UUID getJobPositionId() {
        return jobPositionId;
    }

    public void setJobPositionId(UUID jobPositionId) {
        this.jobPositionId = jobPositionId;
    }

    public NotificationMessagingDto(UUID technicalAdvisorcanditateId, String status, Boolean preselectedTechnicalAdvisor, UUID interviewId,
                                    String description, String interviewType, Boolean urgent, String interviewStatus, String candidateName,
                                    String technicalAdvisorjobPosition, LevelOfExpertise technicalAdvisorLevelOfExpertise, String recruiterName, String recruiterEmail,
                                    String technicalAdvisorEmail, String candidatejobPosition, LevelOfExpertise candidateLevelOfExpertise,
                                    UUID jobPositionId) {
        this.technicalAdvisorcanditateId = technicalAdvisorcanditateId;
        this.status = status;
        this.preselectedTechnicalAdvisor = preselectedTechnicalAdvisor;
        this.interviewId = interviewId;
        this.description = description;
        this.interviewType = interviewType;
        this.urgent = urgent;
        this.interviewStatus = interviewStatus;
        this.candidateName = candidateName;
        this.technicalAdvisorjobPosition = technicalAdvisorjobPosition;
        this.technicalAdvisorLevelOfExpertise = technicalAdvisorLevelOfExpertise;
        this.recruiterName = recruiterName;
        this.recruiterEmail = recruiterEmail;
        this.technicalAdvisorEmail = technicalAdvisorEmail;
        this.candidatejobPosition = candidatejobPosition;
        this.candidateLevelOfExpertise = candidateLevelOfExpertise;
        this.jobPositionId=jobPositionId;
    }
    public NotificationMessagingDto() {
    }

    @Override
    public String toString() {
        return "NotificationMessagingDto{" +
                "message='" + message + '\'' +
                ", copy='" + copy + '\'' +
                ", subject='" + subject + '\'' +
                ", TechnicalAdvisorcanditateId=" + technicalAdvisorcanditateId +
                ", status='" + status + '\'' +
                ", preselectedTechnicalAdvisor=" + preselectedTechnicalAdvisor +
                ", interviewId=" + interviewId +
                ", description='" + description + '\'' +
                ", interviewType='" + interviewType + '\'' +
                ", urgent=" + urgent +
                ", interviewStatus='" + interviewStatus + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", technicalAdvisorjobPosition='" + technicalAdvisorjobPosition + '\'' +
                ", technicalAdvisorLevelOfExpertise=" + technicalAdvisorLevelOfExpertise +
                ", candidatejobPosition='" + candidatejobPosition + '\'' +
                ", candidateLevelOfExpertise=" + candidateLevelOfExpertise +
                ", recruiterName='" + recruiterName + '\'' +
                ", recruiterEmail='" + recruiterEmail + '\'' +
                ", TechnicalAdvisorEmail='" + technicalAdvisorEmail + '\'' +
                '}';
    }
}
