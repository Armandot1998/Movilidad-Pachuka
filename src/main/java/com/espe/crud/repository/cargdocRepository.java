package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.cargdoc;


@Repository
public interface cargdocRepository extends CrudRepository<cargdoc, Long>{
	  List<cargdoc> findById(long id);
}


