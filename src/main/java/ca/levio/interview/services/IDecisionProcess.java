package ca.levio.interview.services;

import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.dtos.SkillInterviewDto;

import java.util.List;
import java.util.UUID;


public interface IDecisionProcess {
    SkillInterviewDto linkInterviewTechnicalAccept(UUID skillId);

    SkillInterviewDto linkInterviewTechnicalReject(UUID skillId);
}
