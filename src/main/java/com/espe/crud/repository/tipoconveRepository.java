package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.tipoconve;


@Repository
public interface tipoconveRepository extends CrudRepository<tipoconve, Long>{
	  List<tipoconve> findById(long id);
}
