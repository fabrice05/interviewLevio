package ca.levio.interview.controllers;

import ca.levio.interview.dtos.LineOfBusinessDto;
import ca.levio.interview.dtos.TechnicalAdvisorDto;
import ca.levio.interview.services.Impl.LineOfBusinessService;
import ca.levio.interview.services.Impl.TechnicalAdvisorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/technicalAdvisor")
public class TechnicalAdvisorController extends BaseManagedOrganisationController<TechnicalAdvisorDto> {
    private final TechnicalAdvisorService technicalAdvisorService;
    public TechnicalAdvisorController(TechnicalAdvisorService technicalAdvisorService) {
        super(technicalAdvisorService);
        this.technicalAdvisorService = technicalAdvisorService;
    }
}
