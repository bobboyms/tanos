package br.com.tanos.management.record.controller;

import br.com.tanos.management.commons.reponse.ResponseDto;
import br.com.tanos.management.record.dto.ParticipantCategoryDto;
import br.com.tanos.management.record.dto.ParticipantDto;
import br.com.tanos.management.record.dto.ParticipantTypeDto;
import br.com.tanos.management.record.model.Participant;
import br.com.tanos.management.record.service.ParticipantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/record/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @Operation(summary = "retorna os tipos de Pessoas (person). Exemplo: FISICO, JURIDICO")
    @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParticipantTypeDto>> getPersonType() {
        return ResponseEntity.ok(participantService.getPersonType());
    }

    @Operation(summary = "retorna as categorias de Pessoas (person). Exemplo: Cliente, Transportadora, Funcionário")
    @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParticipantCategoryDto>> getPersonCategory() {
        return ResponseEntity.ok(participantService.getPersonCategory());
    }

    @Operation(summary = "Retorna um objeto da base de dados")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Participant> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(participantService.findById(id));
    }

    @Operation(summary = "Salva um objeto na base de dados")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody ParticipantDto dto) {
        final Participant obj = participantService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(obj.getId()));
    }

    @Operation(summary = "Atualiza um objeto na base de dados")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> update(@PathVariable("id") Long id, @RequestBody ParticipantDto dto) {
        final Participant obj = participantService.update(id, dto);
        return ResponseEntity.ok(new ResponseDto(obj.getId()));
    }

    @Operation(summary = "Deleta um objeto na base de dados")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        participantService.delete(id);
        return ResponseEntity.ok().build();
    }


}
