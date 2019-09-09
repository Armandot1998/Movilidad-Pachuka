package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.FPublicacionesIndexadas;

public interface FPublicacionesIndexadasRepository  extends CrudRepository<FPublicacionesIndexadas,Long> {
	List<FPublicacionesIndexadas> findById(long id);	
}
