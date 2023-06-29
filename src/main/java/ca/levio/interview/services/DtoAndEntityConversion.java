package ca.levio.interview.services;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.SkillInterview;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.SkillInterviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoAndEntityConversion {
    DtoAndEntityConversion MAPPER = Mappers.getMapper(DtoAndEntityConversion.class);
   Interview mapDTOtoEntity(InterviewDto dto);
    InterviewDto mapEntitytoDTO(Interview Entity);


    SkillInterview mapDTOtoEntity(SkillInterviewDto dto);
    SkillInterviewDto mapEntitytoDTO(SkillInterview Entity);
}
