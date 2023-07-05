package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.Skill;
import ca.levio.interview.db.entities.TechnicalAdvisorInterview;
import ca.levio.interview.dtos.JobPositionDto;
import ca.levio.interview.dtos.SkillDto;
import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;
import ca.levio.interview.services.IDtoAndEntityConversionImpl;

public class DtoAndEntityConversionExtension extends IDtoAndEntityConversionImpl {

    @Override
    public SkillDto mapEntitytoDTO(Skill Entity) {
        SkillDto skillDto =super.mapEntitytoDTO(Entity);
        if ( Entity.getJobPosition() != null ) {
            skillDto.setJobPositionID( Entity.getJobPosition().getId() );
        }
        if ( Entity.getTechnicalAdvisor() != null ) {
            skillDto.setTechnicalAdvisorID( Entity.getTechnicalAdvisor().getId() );
        }

        return skillDto;
    }

    @Override
    public JobPositionDto mapEntitytoDTO(JobPosition Entity) {
        JobPositionDto jobPositionDto =super.mapEntitytoDTO(Entity);
        if ( Entity.getLineOfBusiness() != null ) {
            jobPositionDto.setLineOfBusinessID( Entity.getLineOfBusiness().getId() );
        }

        return jobPositionDto;
    }

    @Override
    public TechnicalAdvisorInterviewDto mapEntitytoDTO(TechnicalAdvisorInterview Entity) {
        TechnicalAdvisorInterviewDto technicalAdvisorInterviewDto =super.mapEntitytoDTO(Entity);
        if ( Entity.getTechnicalAdvisor() != null ) {
            technicalAdvisorInterviewDto.setTechnicalAdvisorId( Entity.getTechnicalAdvisor().getId() );
        }
        if ( Entity.getInterview() != null ) {
            technicalAdvisorInterviewDto.setInterviewId( Entity.getInterview().getId() );
        }
        return technicalAdvisorInterviewDto;
    }
}
