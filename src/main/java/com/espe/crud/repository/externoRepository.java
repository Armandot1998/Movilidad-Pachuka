package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.externo;


@Repository
public interface externoRepository extends CrudRepository<externo, Long>{
	List<externo> findById(long id);
}


