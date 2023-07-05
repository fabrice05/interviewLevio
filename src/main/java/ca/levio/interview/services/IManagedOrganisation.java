package ca.levio.interview.services;

import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.repositories.ITechnicalAdvisorRepository;
import ca.levio.interview.dtos.TechnicalAdvisorDto;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface IManagedOrganisation <T> {
    T saveDto(T s);
    public T getDTo(UUID id);

    public List<T> getAllDto();

    public T deleteDto(UUID id);
}
