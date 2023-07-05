package ca.levio.interview.services;

import ca.levio.interview.dtos.TechnicalAdvisorInterviewDto;

import java.util.UUID;


public interface IDecisionProcess {
    TechnicalAdvisorInterviewDto linkInterviewTechnicalAccept(UUID skillId);

    TechnicalAdvisorInterviewDto linkInterviewTechnicalReject(UUID skillId);
}
