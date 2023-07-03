package ca.levio.interview.controllers;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IDecisionProcess;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/decision")
public class DecisionController {
private final IDecisionProcess decisionProcess;

    public DecisionController(IDecisionProcess decisionProcess) {
        this.decisionProcess = decisionProcess;
    }

    @GetMapping("/accept/{SkillId}")
    public InterviewDto acceptInterview(@PathVariable("SkillId") UUID SkillId) {
        System.out.println("Interview Acceptée");
        decisionProcess.linkInterviewTechnicalAccept(SkillId);
        return null;
    }
    @GetMapping("/reject/{SkillId}")
    public InterviewDto rejectInterview(@PathVariable("SkillId") UUID SkillId) {
        System.out.println("Interview rejetée");
        decisionProcess.linkInterviewTechnicalReject(SkillId);
        return null;
    }
}
