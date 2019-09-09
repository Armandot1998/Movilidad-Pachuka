package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.financiamiento;

public interface financiamientoRepository extends CrudRepository<financiamiento,Long> {
	List<financiamiento> findById(long id);
}
