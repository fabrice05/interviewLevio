package ca.levio.interview.dtos;

import java.util.UUID;

public class TechnicalAdvisorDto {
    private UUID id;
    private String name;
    private boolean isActiv;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActiv() {
        return isActiv;
    }

    public void setActiv(boolean activ) {
        isActiv = activ;
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

    public TechnicalAdvisorDto() {
    }

    public TechnicalAdvisorDto(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TechnicalAdvisorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActiv=" + isActiv +
                ", email='" + email + '\'' +
                '}';
    }
}
