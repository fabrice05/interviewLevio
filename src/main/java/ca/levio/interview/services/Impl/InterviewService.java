package ca.levio.interview.services.Impl;

import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.Skill;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.repositories.IInterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.SkillDto;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InterviewService extends ManageOrganisationStructure<Interview> implements IManagedOrganisation<InterviewDto> {
    final IInterviewRepository interviewRepository;
    public InterviewService(IInterviewRepository interviewRepository) {
        super(interviewRepository);
        this.interviewRepository = interviewRepository;
    }
    @Override
    public InterviewDto saveDto(InterviewDto s) {
        Interview interview= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        interview= super.save(interview);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(interview);
    }

    @Override
    public InterviewDto getDTo(UUID id) {
        Interview interview= super.get(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(interview);
    }
@Override
    public List<InterviewDto> getAllDto() {
        List<Interview> listLineOfBusiness= super.getAll();
        return listLineOfBusiness.stream().map(DtoAndEntityConversionExtension.MAPPER::mapEntitytoDTO).toList();
    }
    @Override
    public InterviewDto deleteDto(UUID id) {
        Interview interview=super.delete(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(interview);
    }
}
