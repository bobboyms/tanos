package br.com.tanos.management.record.service;

import br.com.tanos.management.commons.exception.ObjectNotFoundException;
import br.com.tanos.management.commons.exception.ValidationException;
import br.com.tanos.management.commons.reponse.ValidationMessage;
import br.com.tanos.management.commons.service.CrudService;
import br.com.tanos.management.record.dto.PersonCategoryDto;
import br.com.tanos.management.record.dto.PersonReqDto;
import br.com.tanos.management.record.dto.PersonTypeDto;
import br.com.tanos.management.record.mapper.PersonMapper;
import br.com.tanos.management.record.model.Person;
import br.com.tanos.management.record.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonService implements CrudService<Person, PersonReqDto> {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonTypeDto> getPersonType() {

        return Arrays.asList(new PersonTypeDto("FÍSICO", Person.PersonType.FISICO),
                new PersonTypeDto("JURÍDICO", Person.PersonType.JURIDICO));
    }

    public List<PersonCategoryDto> getPersonCategory() {


        return Arrays.asList(new PersonCategoryDto("CLIENTE", Person.PersonCategory.CUSTOMER),
                new PersonCategoryDto("FORNECEDOR", Person.PersonCategory.SUPPLIER),
                new PersonCategoryDto("TRANSPORTADORA", Person.PersonCategory.SHIPPING_COMPANY),
                new PersonCategoryDto("FUNCIONÁRIO", Person.PersonCategory.EMPLOYEE));

    }

    @Override
    public Person save(PersonReqDto personReqDto) {

        if (personReqDto.getName() == null || personReqDto.getName().trim().length() == 0) {
            throw new ValidationException(Arrays.asList(new ValidationMessage("Deve preencher o nome")));
        }

        final Person person = new ModelMapper().map(personReqDto, Person.class);
        return personRepository.save(person);

    }

    @Override
    public Person update(Long id, PersonReqDto personReqDto) {

        findById(id);

        final Person person = PersonMapper.createPerson(personReqDto);
        person.setId(id);

        return personRepository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).
                orElseThrow(()-> new ObjectNotFoundException(Arrays.
                        asList(new ValidationMessage("Not found object"))));
    }


    @Override
    public void delete(Long id) {
        personRepository.delete(findById(id));
    }
}
