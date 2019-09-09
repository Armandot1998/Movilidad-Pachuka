package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.requisitosplanmov;


@Repository
public interface requisitosplanmovRepository extends CrudRepository<requisitosplanmov, Long>{
	  List<requisitosplanmov> findById(long id);

}
