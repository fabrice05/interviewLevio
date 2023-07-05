package ca.levio.interview.db.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "technical_advisor")
public class TechnicalAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "activ")
    private boolean isActiv;

    @Column(name = "email", length = 100)
    private String email;

    @OneToMany(mappedBy = "technicalAdvisor", orphanRemoval = true)
    private Collection<TechnicalAdvisorInterview> skills = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public Collection<TechnicalAdvisorInterview> getSkills() {
        return skills;
    }

    public void setSkills(Collection<TechnicalAdvisorInterview> skills) {
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getActif() {
        return isActiv;
    }

    public void setActif(boolean actif) {
        isActiv = actif;
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

    public TechnicalAdvisor() {
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public TechnicalAdvisor(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TechnicalAdvisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActiv=" + isActiv +
                ", email='" + email + '\'' +
                '}';
    }
}
