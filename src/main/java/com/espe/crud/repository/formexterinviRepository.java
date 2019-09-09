package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.formexterinvi;


@Repository
public interface formexterinviRepository extends CrudRepository<formexterinvi, Long>{
	List<formexterinvi> findById(long id);
}


