package com.espe.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espe.crud.model.convenio;

@Repository
public interface convenioRepository extends CrudRepository<convenio, Long> {
	List<convenio> findById(long id);

	@Query(value = "SELECT * FROM UZMTCONVENIO WHERE UZMTCONVENIO_ESTADO='1' ORDER BY UZMTCONVENIO_ID", nativeQuery = true)
	List<convenio> findAll();

}
