package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.movbd;


@Repository
public interface movbdRepository extends CrudRepository<movbd, Long>{
	List<movbd> findById(long id);
}


