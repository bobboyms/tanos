package br.com.tanos.management.record.dto;

import br.com.tanos.management.record.model.Person;
import lombok.*;
import br.com.tanos.management.record.model.Person.PersonType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonReqDto {

    private String name;
    private PersonType personType;
    private List<Person.PersonCategory> personCategory;

}
