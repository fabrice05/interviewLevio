package ca.levio.interview.services;

import ca.levio.interview.db.entities.Applicant;
import ca.levio.interview.db.repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(int id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
    }

    public Applicant createApplicant(Applicant recruiter) {
        return applicantRepository.save(recruiter);
    }

    public Applicant updateApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public void deleteApplicant(int id) {
        applicantRepository.deleteById(id);
    }

}
