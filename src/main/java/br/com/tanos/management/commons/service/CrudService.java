package br.com.tanos.management.commons.service;

import br.com.tanos.management.record.dto.PersonReqDto;
import br.com.tanos.management.record.model.Person;

public interface CrudService<T,D> {
    void delete(Long id);
    T findById(Long id);
    T save(D dto);
    T update(Long id, D dto);
}
