package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
@Autowired
InterviewService interviewService;

    @GetMapping
    public List<InterviewDto> getAllInterviews() {
        return interviewService.getAll();
    }

    @GetMapping("/{id}")
    public InterviewDto getInterviewById(@PathVariable UUID id) {
        return interviewService.getApplicantById(id);
    }

    @PostMapping
    public InterviewDto createInterview(@RequestBody InterviewDto interviewDto) {
        return interviewService.createOrUpdate(interviewDto);
    }

    @PutMapping("/{id}")
    public InterviewDto updateInterview(@PathVariable UUID id, @RequestBody InterviewDto interviewDto) {
        return interviewService.createOrUpdate(interviewDto);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable UUID id) {
        interviewService.delete(id);
    }

}
