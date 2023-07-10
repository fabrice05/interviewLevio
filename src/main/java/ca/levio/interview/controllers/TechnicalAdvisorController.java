package ca.levio.interview.controllers;

import ca.levio.interview.dtos.TechnicalAdvisorDto;
import ca.levio.interview.services.Impl.Dto.TechnicalAdvisorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/technicalAdvisor")
public class TechnicalAdvisorController extends BaseManagedOrganisationController<TechnicalAdvisorDto> {
    private final TechnicalAdvisorService technicalAdvisorService;
    public TechnicalAdvisorController(TechnicalAdvisorService technicalAdvisorService) {
        super(technicalAdvisorService);
        this.technicalAdvisorService = technicalAdvisorService;
    }
}
