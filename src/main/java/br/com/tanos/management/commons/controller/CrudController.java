package br.com.tanos.management.commons.controller;

import br.com.tanos.management.commons.service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CrudController<T, D> {

    private final CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }

    @Operation(summary = "Retorna um objeto da base de dados")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> findById(@PathVariable("id") Long id) {
        return (ResponseEntity<T>) ResponseEntity.ok(crudService.findById(id));
    }

    @Operation(summary = "Salva um objeto na base de dados")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> save(@RequestBody D dto) {
        final T obj = (T) crudService.save(dto);
        return (ResponseEntity<D>) ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @Operation(summary = "Atualiza um objeto na base de dados")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@PathVariable("id") Long id, @RequestBody D dto) {
        final T obj = (T) crudService.update(id, dto);
        return (ResponseEntity<D>) ResponseEntity.ok(obj);
    }

    @Operation(summary = "Delete um objeto na base de dados")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> delete(@PathVariable("id") Long id) {
        crudService.delete(id);
        return ResponseEntity.ok().build();
    }



}
