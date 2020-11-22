package br.com.tanos.management.record.dto;

import br.com.tanos.management.record.model.Participant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ParticipantCategoryDto {

    private String label;
    private Participant.ParticipantCategory value;

}
