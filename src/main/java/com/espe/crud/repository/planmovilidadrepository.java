package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.PlanMovilidad;

public interface planmovilidadrepository  extends CrudRepository<PlanMovilidad,Long> {
	List<PlanMovilidad> findById(long id);

}
