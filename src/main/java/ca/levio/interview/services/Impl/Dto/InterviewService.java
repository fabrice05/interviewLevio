package ca.levio.interview.services.Impl.Dto;

import ca.levio.interview.db.entities.Enum.InterviewStatus;
import ca.levio.interview.db.entities.Interview;
import ca.levio.interview.db.repositories.IInterviewRepository;
import ca.levio.interview.dtos.InterviewDto;
import ca.levio.interview.messages.IMessageProducer;
import ca.levio.interview.services.IManagedOrganisation;
import ca.levio.interview.services.ManageOrganisationStructure;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InterviewService extends ManageOrganisationStructure<Interview> implements IManagedOrganisation<InterviewDto> {
    final IInterviewRepository interviewRepository;
    private  final IMessageProducer messageProducer;
    public InterviewService(IInterviewRepository interviewRepository, IMessageProducer messageProducer) {
        super(interviewRepository);
        this.interviewRepository = interviewRepository;
        this.messageProducer = messageProducer;
    }
    @Override
    public InterviewDto saveDto(InterviewDto s) {
        Interview interview= DtoAndEntityConversionExtension.MAPPER.mapDTOtoEntity(s);
        interview.setInterviewStatus(InterviewStatus.OPEN);
        interview= super.save(interview);
        s= DtoAndEntityConversionExtension.MAPPER.mapEntitytoDTO(interview);
        messageProducer.writeMessage(s);
        return s;
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
