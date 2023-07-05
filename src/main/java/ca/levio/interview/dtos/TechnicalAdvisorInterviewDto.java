package ca.levio.interview.dtos;


import java.sql.Date;
import java.util.UUID;

public class TechnicalAdvisorInterviewDto {
    private UUID id;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private boolean firstChoiceTechnical;

    private UUID technicalAdvisorId;

    private UUID interviewId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public boolean isFirstChoiceTechnical() {
        return firstChoiceTechnical;
    }

    public void setFirstChoiceTechnical(boolean firstChoiceTechnical) {
        this.firstChoiceTechnical = firstChoiceTechnical;
    }

    public UUID getTechnicalAdvisorId() {
        return technicalAdvisorId;
    }

    public void setTechnicalAdvisorId(UUID technicalAdvisorId) {
        this.technicalAdvisorId = technicalAdvisorId;
    }

    public UUID getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(UUID interviewId) {
        this.interviewId = interviewId;
    }
}
