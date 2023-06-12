package ca.levio.interview.dtos;


import ca.levio.interview.db.entities.Applicant;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.Recruiter;
import ca.levio.interview.db.entities.SkillInterview;


import java.util.ArrayList;
import java.util.Collection;

public class InterviewDto {
    private Integer id;
    private String description;
    private String interviewType;
    private Boolean isUrgent;
    private int recruiter_id;
    private int applicant_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public Boolean getUrgent() {
        return isUrgent;
    }

    public void setUrgent(Boolean urgent) {
        isUrgent = urgent;
    }

    public int getRecruiter_id() {
        return recruiter_id;
    }

    public void setRecruiter_id(int recruiter_id) {
        this.recruiter_id = recruiter_id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }
    public Interview convertDtoToJPA(){
        Interview it=new Interview();
     it.setId(this.getId());
     it.setDescription(this.getDescription());
     it.setInterviewType(this.getInterviewType());
     it.setUrgent(this.getUrgent());
     return it;
    }

    public InterviewDto convertJPAToDTO(Interview it){
        InterviewDto itdto=new InterviewDto();
        if(it!=null ){
        itdto.setId(it.getId());
        itdto.setDescription(it.getDescription());
        itdto.setInterviewType(it.getInterviewType());
        itdto.setUrgent(it.getUrgent());
        if(it.getApplicant()!=null && it.getApplicant().getId()!=null){
            itdto.setApplicant_id(it.getApplicant().getId());
        }
        if(it.getRecruiter()!=null && it.getRecruiter().getId()!=null){
            itdto.setRecruiter_id(it.getRecruiter().getId());
        }
        }
        return itdto;
    }
}
