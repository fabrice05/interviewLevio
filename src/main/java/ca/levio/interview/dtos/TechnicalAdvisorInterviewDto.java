package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.Enum.TechnicalInterviewStatus;

import java.sql.Date;
import java.util.UUID;

public class TechnicalAdvisorInterviewDto {
    private UUID id;
    private TechnicalInterviewStatus status;
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

    public TechnicalInterviewStatus getStatus() {
        return status;
    }

    public void setStatus(TechnicalInterviewStatus status) {
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

    @Override
    public String toString() {
        return "TechnicalAdvisorInterviewDto{" +
                "id=" + id +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", firstChoiceTechnical=" + firstChoiceTechnical +
                ", technicalAdvisorId=" + technicalAdvisorId +
                ", interviewId=" + interviewId +
                '}';
    }
}
