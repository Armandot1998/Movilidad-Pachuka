package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.gestinv;


@Repository
public interface gestinvRepository extends CrudRepository<gestinv, Long>{
	List<gestinv> findById(long id);
}


