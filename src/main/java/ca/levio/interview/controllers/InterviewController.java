package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
@Autowired
InterviewService interviewService;

    @GetMapping
    public List<Interview> getAllRecruiters() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public Interview getRecruiterById(@PathVariable int id) {
        return interviewService.getInterviewById(id);
    }

    @PostMapping
    public Interview createRecruiter(@RequestBody Interview interview) {
        return interviewService.createInterview(interview);
    }

    @PutMapping("/{id}")
    public Interview updateRecruiter(@PathVariable int id, @RequestBody Interview interview) {
        interview.setId(id);
        return interviewService.updateInterview(interview);
    }

    @DeleteMapping("/{id}")
    public void deleteRecruiter(@PathVariable int id) {
        interviewService.deleteInterview(id);
    }

}
