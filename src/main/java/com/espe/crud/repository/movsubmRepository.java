package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.movsubm;

public interface movsubmRepository extends CrudRepository<movsubm,Long> {
	List<movsubm> findById(long id);
}
