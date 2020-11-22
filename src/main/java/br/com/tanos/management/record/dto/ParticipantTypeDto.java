package br.com.tanos.management.record.dto;

import br.com.tanos.management.record.model.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipantTypeDto {

    private String label;
    private Participant.ParticipantType value;

}
