package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.verificacion;

@Repository
public interface verificacionRepository extends CrudRepository<verificacion,Long>{
	List<verificacion> findById(long id);

}
