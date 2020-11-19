package br.com.tanos.management.record.mapper;


import br.com.tanos.management.record.dto.PersonReqDto;
import br.com.tanos.management.record.model.Person;
import org.modelmapper.ModelMapper;

public class PersonMapper {

    public static PersonReqDto createPersonDto(Person person) {
        return new ModelMapper().map(person, PersonReqDto.class);
    }

    public static Person createPerson(PersonReqDto personReqDto) {
        return new ModelMapper().map(personReqDto, Person.class);
    }


}
