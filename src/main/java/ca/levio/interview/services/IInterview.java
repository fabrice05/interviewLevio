package ca.levio.interview.services;

import ca.levio.interview.configs.AutoEntityMapper;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public interface IInterview {
    public List<InterviewDto> getAll();

    public  InterviewDto getApplicantById(UUID id);

    public InterviewDto createOrUpdate(InterviewDto element_dto);
    public void delete(UUID id);
}
