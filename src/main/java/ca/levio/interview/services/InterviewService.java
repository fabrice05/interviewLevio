package ca.levio.interview.services;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.InterviewRepository;
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

    public Interview createInterview(Interview Interview) {
        return interviewRepository.save(Interview);
    }

    public Interview updateInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void deleteInterview(int id) {
        interviewRepository.deleteById(id);
    }
}
