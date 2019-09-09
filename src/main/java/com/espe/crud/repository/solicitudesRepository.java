package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.solicitudes;


@Repository
public interface solicitudesRepository extends CrudRepository<solicitudes,Long>{
	List<solicitudes> findById(long id);

}
