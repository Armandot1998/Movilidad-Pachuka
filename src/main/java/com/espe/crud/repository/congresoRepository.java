package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.Congreso;


@Repository
public interface congresoRepository extends CrudRepository<Congreso,Long>{
	  List<Congreso> findById(long id);
}
