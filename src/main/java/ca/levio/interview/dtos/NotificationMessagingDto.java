package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.Enum.ELevelOfExpertise;
import ca.levio.interview.db.entities.Enum.InterviewStatus;
import ca.levio.interview.db.entities.Enum.InterviewType;

import java.io.Serializable;
import java.util.UUID;

public class NotificationMessagingDto implements Serializable {
    private String candidatejobPosition;
   private String technicalAdvisorName;
    private String technicalAdvisorEmail;
    private UUID technicalAdvisorIntervewId;
    private String serverLink;
    private String recruiterEmail;

    public String getCandidatejobPosition() {
        return candidatejobPosition;
    }

    public void setCandidatejobPosition(String candidatejobPosition) {
        this.candidatejobPosition = candidatejobPosition;
    }

    public String getTechnicalAdvisorName() {
        return technicalAdvisorName;
    }

    public void setTechnicalAdvisorName(String technicalAdvisorName) {
        this.technicalAdvisorName = technicalAdvisorName;
    }

    public String getTechnicalAdvisorEmail() {
        return technicalAdvisorEmail;
    }

    public void setTechnicalAdvisorEmail(String technicalAdvisorEmail) {
        this.technicalAdvisorEmail = technicalAdvisorEmail;
    }

    public UUID getTechnicalAdvisorIntervewId() {
        return technicalAdvisorIntervewId;
    }

    public void setTechnicalAdvisorIntervewId(UUID technicalAdvisorIntervewId) {
        this.technicalAdvisorIntervewId = technicalAdvisorIntervewId;
    }

    public String getServerLink() {
        return serverLink;
    }

    public void setServerLink(String serverLink) {
        this.serverLink = serverLink;
    }

    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }
}
