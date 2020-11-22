package br.com.tanos.management.record.dto;

import br.com.tanos.management.commons.validations.pariticipant.Category;
import br.com.tanos.management.commons.validations.pariticipant.Type;
import br.com.tanos.management.commons.validations.cpf.Cpf;
import br.com.tanos.management.commons.validations.cpf.SingleCpf;
import br.com.tanos.management.record.model.Participant;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import br.com.tanos.management.record.model.Participant.ParticipantType;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParticipantDto {

    @JsonProperty("name")
    @NotBlank(message = "Name  is required")
    private String name;

    @Cpf
    @SingleCpf
    private String cpf;

    @Type
    private ParticipantType participantType;

    @Category
    private List<Participant.ParticipantCategory> participantCategory;

}
