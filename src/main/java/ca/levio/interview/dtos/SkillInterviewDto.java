package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.UUID;

public class SkillInterviewDto {
    private UUID id;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private Boolean firstChoiceTechnical;

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

    public Boolean getFirstChoiceTechnical() {
        return firstChoiceTechnical;
    }

    public void setFirstChoiceTechnical(Boolean firstChoiceTechnical) {
        this.firstChoiceTechnical = firstChoiceTechnical;
    }
}
