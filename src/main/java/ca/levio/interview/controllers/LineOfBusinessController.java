package ca.levio.interview.controllers;

import ca.levio.interview.dtos.LineOfBusinessDto;
import ca.levio.interview.services.Impl.Dto.LineOfBusinessService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/lineOfbusiness")
public class LineOfBusinessController extends BaseManagedOrganisationController<LineOfBusinessDto> {
    private final LineOfBusinessService lineOfBusinessService;
    public LineOfBusinessController(LineOfBusinessService lineOfBusinessService) {
        super(lineOfBusinessService);
        this.lineOfBusinessService = lineOfBusinessService;
    }
}
