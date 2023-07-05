package ca.levio.interview.services;

import ca.levio.interview.db.entities.*;
import ca.levio.interview.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDtoAndEntityConversion {
   public IDtoAndEntityConversion MAPPER = Mappers.getMapper(IDtoAndEntityConversion.class);
  Interview mapDTOtoEntity(InterviewDto dto);
    InterviewDto mapEntitytoDTO(Interview Entity);


    TechnicalAdvisorInterview mapDTOtoEntity(TechnicalAdvisorInterviewDto dto);
    TechnicalAdvisorInterviewDto mapEntitytoDTO(TechnicalAdvisorInterview Entity);


    TechnicalAdvisor mapDTOtoEntity(TechnicalAdvisorDto dto);
    TechnicalAdvisorDto mapEntitytoDTO(TechnicalAdvisor Entity);



    Skill mapDTOtoEntity(SkillDto dto);
    SkillDto mapEntitytoDTO(Skill Entity);



    JobPosition mapDTOtoEntity(JobPositionDto dto);
    JobPositionDto mapEntitytoDTO(JobPosition Entity);

    LineOfBusiness mapDTOtoEntity(LineOfBusinessDto dto);
    LineOfBusinessDto mapEntitytoDTO(LineOfBusiness Entity);

}
