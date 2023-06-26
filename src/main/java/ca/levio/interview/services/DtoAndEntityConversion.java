package ca.levio.interview.services;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.dtos.InterviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoAndEntityConversion {
    DtoAndEntityConversion MAPPER = Mappers.getMapper(DtoAndEntityConversion.class);
   Interview mapDTOtoEntity(InterviewDto dto);
    InterviewDto mapJPAtoDTO(Interview Entity);
}
