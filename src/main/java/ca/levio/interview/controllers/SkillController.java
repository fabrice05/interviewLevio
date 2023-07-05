package ca.levio.interview.controllers;

import ca.levio.interview.dtos.SkillDto;
import ca.levio.interview.services.Impl.SkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skill")
public class SkillController extends BaseManagedOrganisationController<SkillDto> {
    private final SkillService skillService;
    public SkillController(SkillService skillService) {
        super(skillService);
        this.skillService = skillService;
    }
}
