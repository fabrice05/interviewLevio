package ca.levio.interview.dtos;




import java.util.UUID;

public class SkillDto {
    private UUID id;


    private String levelOfExpertise;


    private UUID jobPositionID;


    private UUID technicalAdvisorID;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLevelOfExpertise() {
        return levelOfExpertise;
    }

    public void setLevelOfExpertise(String levelOfExpertise) {
        this.levelOfExpertise = levelOfExpertise;
    }

    public UUID getJobPositionID() {
        return jobPositionID;
    }

    public void setJobPositionID(UUID jobPositionID) {
        this.jobPositionID = jobPositionID;
    }

    public UUID getTechnicalAdvisorID() {
        return technicalAdvisorID;
    }

    public void setTechnicalAdvisorID(UUID technicalAdvisorID) {
        this.technicalAdvisorID = technicalAdvisorID;
    }
}
