package ca.levio.interview.controllers;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
private final IInterviewProcess interview;

    public InterviewController(IInterviewProcess interviewService) {
        this.interview = interviewService;
    }

    @GetMapping
    public List<InterviewDto> getAllInterviews() {
        return interview.getAll();
    }

    @GetMapping("/{id}")
    public InterviewDto getInterviewById(@PathVariable UUID id) {
        return interview.getApplicant(id);
    }

    @PostMapping
    public InterviewDto createInterview(@RequestBody InterviewDto interviewDto) {
        return interview.createOrUpdate(interviewDto);
    }

    @PutMapping("/{id}")
    public InterviewDto updateInterview(@PathVariable UUID id, @RequestBody InterviewDto interviewDto) {
        return interview.createOrUpdate(interviewDto);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable UUID id) {
        interview.delete(id);
    }

}
