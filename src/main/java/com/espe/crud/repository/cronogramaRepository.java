package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.Cronograma;

public interface cronogramaRepository extends CrudRepository<Cronograma, Long> {
	List<Cronograma> findById(long id);

}
