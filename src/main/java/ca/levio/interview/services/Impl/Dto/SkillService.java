package ca.levio.interview.services.Impl.Dto;

import ca.levio.interview.db.entities.JobPosition;
import ca.levio.interview.db.entities.Skill;
import ca.levio.interview.db.entities.TechnicalAdvisor;
import ca.levio.interview.db.repositories.IJobPositionRepository;
import ca.levio.interview.db.repositories.ISkillRepository;
import ca.levio.interview.db.repositories.ITechnicalAdvisorRepository;
import ca.levio.interview.dtos.SkillDto;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SkillService extends ManageOrganisationStructure<Skill> implements IManagedOrganisation<SkillDto> {
    final ISkillRepository skillRepository;
    final IJobPositionRepository jobPositionRepository;
    final ITechnicalAdvisorRepository technicalAdvisorRepository;

    public SkillService(ISkillRepository skillRepository, IJobPositionRepository jobPositionRepository, ITechnicalAdvisorRepository technicalAdvisorRepository) {
        super(skillRepository);
        this.skillRepository = skillRepository;
        this.jobPositionRepository = jobPositionRepository;
        this.technicalAdvisorRepository = technicalAdvisorRepository;
    }
    @Override
    public SkillDto saveDto(SkillDto s) {
        Skill skill= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        TechnicalAdvisor technicalAdvisor= technicalAdvisorRepository.getReferenceById(s.getTechnicalAdvisorID());
        skill.setTechnicalAdvisor(technicalAdvisor);
        JobPosition jobPosition= jobPositionRepository.getReferenceById(s.getJobPositionID());
        skill.setJobPosition(jobPosition);
        skill= super.save(skill);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(skill);
    }

    @Override
    public SkillDto getDTo(UUID id) {
        Skill skill= super.get(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(skill);
    }
@Override
    public List<SkillDto> getAllDto() {
        List<Skill> listLineOfBusiness= super.getAll();
        return listLineOfBusiness.stream().map(DtoAndEntityConversionExtension.MAPPER::mapEntitytoDTO).toList();
    }
    @Override
    public SkillDto deleteDto(UUID id) {
        Skill skill=super.delete(id);
        return DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(skill);
    }
}
