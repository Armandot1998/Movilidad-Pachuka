package com.espe.crud.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.tipdoc;


@Repository
public interface tipdocRepository extends CrudRepository<tipdoc, Long>{
	List<tipdoc> findById(long id);
	
}


