package br.com.tanos.management.record.controller;

import br.com.tanos.management.commons.controller.CrudController;
import br.com.tanos.management.record.dto.PersonCategoryDto;
import br.com.tanos.management.record.dto.PersonReqDto;
import br.com.tanos.management.record.dto.PersonTypeDto;
import br.com.tanos.management.record.model.Person;
import br.com.tanos.management.record.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/record/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController extends CrudController<Person, PersonReqDto> {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        super(personService);
        this.personService = personService;
    }

    @Operation(summary = "retorna os tipos de Pessoas (person). Exemplo: FISICO, JURIDICO")
    @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonTypeDto>> getPersonType() {
        return ResponseEntity.ok(personService.getPersonType());
    }

    @Operation(summary = "retorna as categorias de Pessoas (person). Exemplo: Cliente, Transportadora, Funcionário")
    @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonCategoryDto>> getPersonCategory() {
        return ResponseEntity.ok(personService.getPersonCategory());
    }


}
