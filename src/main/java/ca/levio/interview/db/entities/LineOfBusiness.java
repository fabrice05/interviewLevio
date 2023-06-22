package ca.levio.interview.db.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "lineofbusiness")
public class LineOfBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @OneToMany(mappedBy = "lineOfBusiness", orphanRemoval = true)
    private Collection<JobPosition> jobPositions = new ArrayList<>();

    public Collection<JobPosition> getJobPositions() {
        return jobPositions;
    }

    public void setJobPositions(Collection<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
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
}
