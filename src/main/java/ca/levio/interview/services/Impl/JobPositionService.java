package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.LineOfBusiness;
import ca.levio.interview.db.repositories.IJobPositionRepository;
import ca.levio.interview.db.repositories.ILineOfBusinessRepository;
import ca.levio.interview.dtos.JobPositionDto;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobPositionService extends ManageOrganisationStructure<JobPosition> implements IManagedOrganisation<JobPositionDto> {
    final IJobPositionRepository jobPositionRepository;
    final ILineOfBusinessRepository lineOfBusinessRepository;
    public JobPositionService(IJobPositionRepository jobPositionRepository, ILineOfBusinessRepository lineOfBusinessRepository) {
        super(jobPositionRepository);
        this.jobPositionRepository = jobPositionRepository;
        this.lineOfBusinessRepository = lineOfBusinessRepository;
    }



    public JobPositionDto saveDto(JobPositionDto s) {
        JobPosition JobPosition= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        LineOfBusiness lineOfBusiness= lineOfBusinessRepository.getReferenceById(s.getLineOfBusinessID());
        JobPosition.setLineOfBusiness(lineOfBusiness);
        JobPosition= super.save(JobPosition);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(JobPosition);
    }


    public JobPositionDto getDTo(UUID id) {
        JobPosition JobPosition= super.get(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(JobPosition);
    }

    public List<JobPositionDto> getAllDto() {
        List<JobPosition> listJobPosition= super.getAll();
        return listJobPosition.stream().map(DtoAndEntityConversionExtension.MAPPER::mapEntitytoDTO).toList();
    }

    public JobPositionDto deleteDto(UUID id) {
        JobPosition JobPosition=super.delete(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(JobPosition);
    }
}
