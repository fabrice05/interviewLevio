package ca.levio.interview.services.Impl;

import ca.levio.interview.configs.AutoEntityMapper;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IInterview;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InterviewService implements IInterview {
    private final InterviewRepository repository;
    private final TechnicalAdvisorCheking technical;

    public InterviewService(InterviewRepository repository, TechnicalAdvisorCheking technical) {
        this.repository = repository;
        this.technical = technical;
    }
    private List<InterviewDto> mapList(List<Interview> source) {
        //Todo : pourquoi tu rajoutes un cast explicite ??
        return (List<InterviewDto>) source
                .stream()
                .map(element -> AutoEntityMapper.MAPPER.mapJPAtoDTO(element))
                .collect(Collectors.toList());
    }

    public List<InterviewDto> getAll() {
        return mapList(repository.findAll());
    }

    //Todo : nommage ????
    public  InterviewDto getApplicantById(UUID id) {
        Interview element_jpa=  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        //Todo : pourquoi ce cast ?
        return (InterviewDto) AutoEntityMapper.MAPPER.mapJPAtoDTO(element_jpa);
    }

    public InterviewDto createOrUpdate(InterviewDto element_dto) {
        Interview element_jpa = AutoEntityMapper.MAPPER.mapDTOtoJPA(element_dto);
        element_jpa= repository.save(element_jpa);
        //Todo : tu fais ca en synchrone ? on a convenu de passer par Kafka pour cette partie
        technical.createTechnicalChoise(element_jpa);
        //Todo : pourquoi ce cast ?
        return (InterviewDto) AutoEntityMapper.MAPPER.mapJPAtoDTO(element_jpa);
    }
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public String toString() {
        return "InterviewService{" +
                "repository=" + repository.findAll()+ "}";
    }


}
