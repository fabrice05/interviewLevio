package ca.levio.interview.services.Impl.Dto;

import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.repositories.ITechnicalAdvisorRepository;
import ca.levio.interview.dtos.TechnicalAdvisorDto;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TechnicalAdvisorService extends ManageOrganisationStructure<TechnicalAdvisor> implements IManagedOrganisation<TechnicalAdvisorDto> {
    final ITechnicalAdvisorRepository technicalAdvisorRepository;

    public TechnicalAdvisorService(ITechnicalAdvisorRepository technicalAdvisorRepository) {
        super(technicalAdvisorRepository);
        this.technicalAdvisorRepository = technicalAdvisorRepository;
    }

    public TechnicalAdvisorDto saveDto(TechnicalAdvisorDto s) {
        System.out.println("DTO "+s);
        TechnicalAdvisor technicalAdvisor= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        technicalAdvisor= super.save(technicalAdvisor);
        System.out.println("ENT "+technicalAdvisor);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisor);
    }


    public TechnicalAdvisorDto getDTo(UUID id) {
        TechnicalAdvisor technicalAdvisor= super.get(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisor);
    }

    public List<TechnicalAdvisorDto> getAllDto() {
        List<TechnicalAdvisor> listLineOfBusiness= super.getAll();
        return listLineOfBusiness.stream().map(DtoAndEntityConversionExtension.MAPPER::mapEntitytoDTO).toList();
    }

    public TechnicalAdvisorDto deleteDto(UUID id) {
        TechnicalAdvisor technicalAdvisor=super.delete(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(technicalAdvisor);
    }
}
