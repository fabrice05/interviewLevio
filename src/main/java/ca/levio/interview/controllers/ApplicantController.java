package ca.levio.interview.controllers;

import ca.levio.interview.db.entities.Applicant;
import ca.levio.interview.services.ApplicantService;
import ca.levio.interview.services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
@Autowired
ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable int id) {
        return applicantService.getApplicantById(id);
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }

    @PutMapping("/{id}")
    public Applicant updateApplicant(@PathVariable int id, @RequestBody Applicant applicant) {
        applicant.setId(id);
        return applicantService.updateApplicant(applicant);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable int id) {
        applicantService.deleteApplicant(id);
    }

}
