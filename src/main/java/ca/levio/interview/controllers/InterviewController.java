package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.dtos.InterviewDto;
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
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public InterviewDto getInterviewById(@PathVariable int id) {
        Interview it=interviewService.getInterviewById(id);
        InterviewDto dto=new InterviewDto();
      return  dto.convertJPAToDTO(it);
    }

    @PostMapping
    public Interview createInterview(@RequestBody InterviewDto interviewDto) {
        return interviewService.createInterview(interviewDto);
    }

    @PutMapping("/{id}")
    public Interview updateInterview(@PathVariable int id, @RequestBody InterviewDto interviewDto) {
        return interviewService.updateInterview(interviewDto);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable int id) {
        interviewService.deleteInterview(id);
    }

}
