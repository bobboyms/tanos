package br.com.tanos.management.commons.service;

public interface CrudService<T,D> {
    void delete(Long id);
    T findById(Long id);
    T save(D dto);
    T update(Long id, D dto);
}
