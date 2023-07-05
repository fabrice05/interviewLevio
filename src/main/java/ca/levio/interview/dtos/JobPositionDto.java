package ca.levio.interview.dtos;



import java.util.UUID;


public class JobPositionDto {
    private UUID id;
    private String name;
    private UUID jobPositionParentID;
    private UUID lineOfBusinessID;

    public UUID getJobPositionParentID() {
        return jobPositionParentID;
    }

    public void setJobPositionParentID(UUID jobPositionParentID) {
        this.jobPositionParentID = jobPositionParentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public JobPositionDto() {
    }

    public UUID getLineOfBusinessID() {
        return lineOfBusinessID;
    }

    public void setLineOfBusinessID(UUID lineOfBusinessID) {
        this.lineOfBusinessID = lineOfBusinessID;
    }
}
