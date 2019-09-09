package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.requisitos;

public interface requisitosRepository extends CrudRepository<requisitos,Long>{
	List<requisitos> findById(long id);
}
