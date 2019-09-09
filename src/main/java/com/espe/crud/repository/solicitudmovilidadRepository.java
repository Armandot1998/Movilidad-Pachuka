package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.espe.crud.model.solicitudmovilidad;

@Repository
public interface solicitudmovilidadRepository extends CrudRepository<solicitudmovilidad,Long> {
	List< solicitudmovilidad> findById(long id);
}
