package ca.levio.interview.services.Impl.Dto;

import ca.levio.interview.db.entities.LineOfBusiness;
import ca.levio.interview.db.repositories.ILineOfBusinessRepository;
import ca.levio.interview.dtos.LineOfBusinessDto;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class LineOfBusinessService extends ManageOrganisationStructure<LineOfBusiness> implements IManagedOrganisation<LineOfBusinessDto> {
    final ILineOfBusinessRepository lineOfBusinessRepository;

    public LineOfBusinessService( ILineOfBusinessRepository lineOfBusinessRepository) {
        super(lineOfBusinessRepository);
        this.lineOfBusinessRepository = lineOfBusinessRepository;
    }


    public LineOfBusinessDto saveDto(LineOfBusinessDto s) {
     LineOfBusiness lineOfBusiness= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        lineOfBusiness= super.save(lineOfBusiness);
     return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(lineOfBusiness);
    }

    //public LineOfBusiness mqp


    public LineOfBusinessDto getDTo(UUID id) {
        LineOfBusiness lineOfBusiness= super.get(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(lineOfBusiness);
    }

    public List<LineOfBusinessDto> getAllDto() {
        List<LineOfBusiness> listLineOfBusiness= super.getAll();
       return listLineOfBusiness.stream().map(DtoAndEntityConversionExtension.MAPPER::mapEntitytoDTO).toList();
    }

    public LineOfBusinessDto deleteDto(UUID id) {
        LineOfBusiness lineOfBusiness=super.delete(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(lineOfBusiness);
    }
}
