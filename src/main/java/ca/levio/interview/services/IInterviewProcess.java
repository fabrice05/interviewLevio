package ca.levio.interview.services;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.SkillInterviewDto;

import java.util.List;
import java.util.UUID;


public interface IInterviewProcess {
    public List<InterviewDto> getAll();

    public  InterviewDto getApplicant(UUID id);

    public InterviewDto createOrUpdate(InterviewDto element_dto);
    public void delete(UUID id);

    SkillInterviewDto linkInterviewTechnicalAccept(UUID skillId);

    SkillInterviewDto linkInterviewTechnicalReject(UUID skillId);
}
