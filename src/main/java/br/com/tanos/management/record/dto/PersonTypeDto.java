package br.com.tanos.management.record.dto;

import br.com.tanos.management.record.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonTypeDto {

    private String label;
    private Person.PersonType value;

}
