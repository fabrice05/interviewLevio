package ca.levio.interview.controllers;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.Impl.Dto.InterviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
public class InterviewController extends BaseManagedOrganisationController<InterviewDto>{
private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        super(interviewService);
        this.interviewService = interviewService;
    }
}
