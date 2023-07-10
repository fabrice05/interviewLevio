package ca.levio.interview.db.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "job_position")
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 150,unique = true)
    private String name;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "line_of_business_id", nullable = false)
    private LineOfBusiness lineOfBusiness;

    @ManyToOne(optional = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "job_parent_id")
    private JobPosition jobPosition;

    @OneToMany(mappedBy = "jobPosition", orphanRemoval = true)
    private Collection<Skill> skills = new ArrayList<>();

    public JobPosition(UUID jobPositionId) {
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LineOfBusiness getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(LineOfBusiness lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
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

    public JobPosition() {
    }
}
