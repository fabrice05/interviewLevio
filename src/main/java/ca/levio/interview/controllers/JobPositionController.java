package ca.levio.interview.controllers;

import ca.levio.interview.dtos.JobPositionDto;
import ca.levio.interview.services.Impl.JobPositionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobPosition")
public class JobPositionController extends BaseManagedOrganisationController<JobPositionDto>{
    private final JobPositionService jobPositionService;

    public JobPositionController(JobPositionService jobPositionService) {
        super(jobPositionService);
        this.jobPositionService = jobPositionService;
    }

}
