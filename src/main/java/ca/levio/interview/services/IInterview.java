package ca.levio.interview.services;

import ca.levio.interview.configs.AutoEntityMapper;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


//Todo : attention au nom de ton interface, ca n'est pas une interface pour un objet Interview mais plutot pour un service non ?
public interface IInterview {
    public List<InterviewDto> getAll();

    //Todo : qu'est-ce que ce nom vient faire là ?
    public  InterviewDto getApplicantById(UUID id);

    public InterviewDto createOrUpdate(InterviewDto element_dto);
    public void delete(UUID id);
}
