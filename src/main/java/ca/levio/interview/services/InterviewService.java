package ca.levio.interview.services;

import ca.levio.interview.db.entities.Applicant;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.Recruiter;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    InterviewRepository interviewRepository;
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(int id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    public Interview createInterview(InterviewDto interviewDto) {
        return getInterview(interviewDto);
    }

    public Interview updateInterview(InterviewDto interviewDto) {
        return getInterview(interviewDto);
    }

    private Interview getInterview(InterviewDto interviewDto) {
        Interview et=interviewDto.convertDtoToJPA();
        Applicant ap=new Applicant();
        ap.setId(interviewDto.getApplicant_id());
        et.setApplicant(ap);

        Recruiter re=new Recruiter();
        re.setId(interviewDto.getRecruiter_id());
        et.setRecruiter(re);
        return interviewRepository.save(et);
    }

    public void deleteInterview(int id) {
        interviewRepository.deleteById(id);
    }
}
