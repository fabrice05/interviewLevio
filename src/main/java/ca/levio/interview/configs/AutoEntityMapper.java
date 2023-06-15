package ca.levio.interview.configs;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.dtos.InterviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface AutoEntityMapper {
    AutoEntityMapper MAPPER = Mappers.getMapper(AutoEntityMapper.class);
   Interview mapDTOtoJPA(InterviewDto dto);
    InterviewDto mapJPAtoDTO(Interview jpa);
}
