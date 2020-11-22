package br.com.tanos.management.record.service;

import br.com.tanos.management.commons.exception.ObjectNotFoundException;
import br.com.tanos.management.commons.exception.ValidationException;
import br.com.tanos.management.commons.reponse.ValidationMessage;
import br.com.tanos.management.commons.service.CrudService;
import br.com.tanos.management.commons.validations.ValidationCpf;
import br.com.tanos.management.commons.validations.ValidationString;
import br.com.tanos.management.record.dto.ParticipantCategoryDto;
import br.com.tanos.management.record.dto.ParticipantDto;
import br.com.tanos.management.record.dto.ParticipantTypeDto;
import br.com.tanos.management.record.mapper.PersonMapper;
import br.com.tanos.management.record.model.Participant;
import br.com.tanos.management.record.repository.ParticipantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ParticipantService implements CrudService<Participant, ParticipantDto> {

    private final ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<ParticipantTypeDto> getPersonType() {

        return Arrays.asList(new ParticipantTypeDto("FÍSICO", Participant.ParticipantType.FISICO),
                new ParticipantTypeDto("JURÍDICO", Participant.ParticipantType.JURIDICO));
    }

    public List<ParticipantCategoryDto> getPersonCategory() {


        return Arrays.asList(new ParticipantCategoryDto("CLIENTE", Participant.ParticipantCategory.CUSTOMER),
                new ParticipantCategoryDto("FORNECEDOR", Participant.ParticipantCategory.SUPPLIER),
                new ParticipantCategoryDto("TRANSPORTADORA", Participant.ParticipantCategory.SHIPPING_COMPANY),
                new ParticipantCategoryDto("FUNCIONÁRIO", Participant.ParticipantCategory.EMPLOYEE));

    }

    public List<ValidationMessage> validade(ParticipantDto participantDto) {

        final List<ValidationMessage> messages = new ArrayList<>();

//        if (!ValidationString.isValid(participantDto.getName())) {
//            messages.add(new ValidationMessage("Invalid name value"));
//        }
//
//        if (!ValidationCpf.isValid(participantDto.getCpf())) {
//            messages.add(new ValidationMessage("Invalid CPF value"));
//        }
//
//        if (participantRepository.findByCpf(participantDto.getCpf()).isPresent()) {
//            messages.add(new ValidationMessage("CPF in use"));
//        }
//


        return messages;

    }

    @Override
    public Participant save(ParticipantDto participantDto) {

        final List<ValidationMessage> validationMessages = validade(participantDto);

        if(validationMessages.isEmpty()) {
            Participant participant = new ModelMapper().map(participantDto, Participant.class);
            return participantRepository.save(participant);
        }

        throw new ValidationException(validationMessages);

    }

    @Override
    public Participant update(Long id, ParticipantDto participantDto) {

        findById(id);

        final List<ValidationMessage> validationMessages = validade(participantDto);

        if(validationMessages.isEmpty()) {
            final Participant participant = PersonMapper.createPerson(participantDto);
            participant.setId(id);
            return participantRepository.save(participant);
        }

        throw new ValidationException(validationMessages);

    }

    @Override
    public Participant findById(Long id) {
        return participantRepository.findById(id).
                orElseThrow(()-> new ObjectNotFoundException(Arrays.
                        asList(new ValidationMessage("Not found object"))));
    }


    @Override
    public void delete(Long id) {
        participantRepository.delete(findById(id));
    }
}
