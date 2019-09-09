package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.espe.crud.model.requisitosmovsubm;

public interface requisitosmovsubmRepository extends CrudRepository<requisitosmovsubm,Long>  {
	List<requisitosmovsubm> findById(long id);
}
