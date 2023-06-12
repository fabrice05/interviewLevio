package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Recruiter;
import ca.levio.interview.services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {
@Autowired
RecruiterService recruiterService;

    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        return recruiterService.getRecruiterById(id);
    }

    @PostMapping
    public Recruiter createRecruiter(@RequestBody Recruiter Recruiter) {
        return recruiterService.createRecruiter(Recruiter);
    }

    @PutMapping("/{id}")
    public Recruiter updateRecruiter(@PathVariable int id, @RequestBody Recruiter Recruiter) {
        Recruiter.setId(id);
        return recruiterService.updateRecruiter(Recruiter);
    }

    @DeleteMapping("/{id}")
    public void deleteRecruiter(@PathVariable int id) {
        recruiterService.deleteRecruiter(id);
    }

}
