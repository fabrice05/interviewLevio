package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import java.util.UUID;

@Entity()
@Immutable
@Subselect("select * from technical_advisor_skill")
public class TechnicalAdvisorAndSkill {

    @Column(name = "levelofexpertiseskill", nullable = false)
    private LevelOfExpertise levelOfExpertise;
    @Column(name = "job_position_id", nullable = false)
    private UUID jobPositionId;
    @Id
    @Column(name = "technical_advisor_id", nullable = false)
    private UUID technicalAdvisorId;
    @Column(name = "line_of_business_id", nullable = false)
    private UUID lineOfBusinessId;
    @Column(name = "job_name", nullable = false, length = 150)
    private String jobName;
    @Column(name = "job_parent_id", nullable = false)
    private UUID jobParentId;
    @Column(name = "technicaladvisorname", nullable = false, length = 150)
    private String technicalAdvisorName;


    @Column(name = "technicaladvisoractif")
    private Boolean technicalAdvisorActif;

    @Column(name = "technicaladvisoremail", length = 100)
    private String technicalAdvisorEmail;
    public LevelOfExpertise getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(LevelOfExpertise levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }



    public String getTechnicalAdvisorName() {
        return technicalAdvisorName;
    }

    public void setTechnicalAdvisorName(String technicalAdvisorName) {
        this.technicalAdvisorName = technicalAdvisorName;
    }

    public Boolean getTechnicalAdvisorActif() {
        return technicalAdvisorActif;
    }

    public void setTechnicalAdvisorActif(Boolean technicalAdvisorActif) {
        this.technicalAdvisorActif = technicalAdvisorActif;
    }

    public String getTechnicalAdvisorEmail() {
        return technicalAdvisorEmail;
    }

    public void setTechnicalAdvisorEmail(String technicalAdvisorEmail) {
        this.technicalAdvisorEmail = technicalAdvisorEmail;
    }

    public UUID getJobPositionId() {
        return jobPositionId;
    }

    public void setJobPositionId(UUID jobPositionId) {
        this.jobPositionId = jobPositionId;
    }

    public UUID getTechnicalAdvisorId() {
        return technicalAdvisorId;
    }

    public void setTechnicalAdvisorId(UUID technicalAdvisorId) {
        this.technicalAdvisorId = technicalAdvisorId;
    }

    public UUID getLineOfBusinessId() {
        return lineOfBusinessId;
    }

    public void setLineOfBusinessId(UUID lineOfBusinessId) {
        this.lineOfBusinessId = lineOfBusinessId;
    }

    public UUID getJobParentId() {
        return jobParentId;
    }

    public void setJobParentId(UUID jobParentId) {
        this.jobParentId = jobParentId;
    }

    @Override
    public String toString() {
        return "TechnicalAdvisorAndSkill{" +
                ", levelOfExpertise=" + levelOfExpertise +
                ", jobPositionId=" + jobPositionId +
                ", technicalAdvisorId=" + technicalAdvisorId +
                ", lineOfBusinessId=" + lineOfBusinessId +
                ", jobName='" + jobName + '\'' +
                ", jobParentId=" + jobParentId +
                ", technicalAdvisorName='" + technicalAdvisorName + '\'' +
                ", technicalAdvisorActif=" + technicalAdvisorActif +
                ", technicalAdvisorEmail='" + technicalAdvisorEmail + '\'' +
                '}';
    }
}

