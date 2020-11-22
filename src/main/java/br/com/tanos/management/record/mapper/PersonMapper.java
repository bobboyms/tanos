package br.com.tanos.management.record.mapper;


import br.com.tanos.management.record.dto.ParticipantDto;
import br.com.tanos.management.record.model.Participant;
import org.modelmapper.ModelMapper;

public class PersonMapper {

    public static ParticipantDto createPersonDto(Participant participant) {
        return new ModelMapper().map(participant, ParticipantDto.class);
    }

    public static Participant createPerson(ParticipantDto participantDto) {
        return new ModelMapper().map(participantDto, Participant.class);
    }


}
