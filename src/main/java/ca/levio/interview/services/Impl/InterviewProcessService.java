package ca.levio.interview.services.Impl;

import ca.levio.interview.services.DtoAndEntityConversion;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.InterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.services.IInterviewProcess;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InterviewProcessService implements IInterviewProcess {
    private final InterviewRepository repository;
    private final TechnicalAdvisorCheking technical;

    public InterviewProcessService(InterviewRepository repository, TechnicalAdvisorCheking technical) {
        this.repository = repository;
        this.technical = technical;
    }
    private List<InterviewDto> mapList(List<Interview> source) {
        return  source
                .stream()
                .map(element -> DtoAndEntityConversion.MAPPER.mapJPAtoDTO(element))
                .collect(Collectors.toList());
    }

    public List<InterviewDto> getAll() {
        return mapList(repository.findAll());
    }

    public  InterviewDto getApplicant(UUID id) {
        Interview element_jpa=  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found"));
        return  DtoAndEntityConversion.MAPPER.mapJPAtoDTO(element_jpa);
    }

    public InterviewDto createOrUpdate(InterviewDto element_dto) {
        Interview element_jpa = DtoAndEntityConversion.MAPPER.mapDTOtoEntity(element_dto);
        element_jpa= repository.save(element_jpa);
        technical.createTechnicalChoise(element_jpa);
        return  DtoAndEntityConversion.MAPPER.mapJPAtoDTO(element_jpa);
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
