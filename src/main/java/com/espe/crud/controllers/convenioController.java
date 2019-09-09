package com.espe.crud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.espe.crud.model.convenio;
import com.espe.crud.repository.convenioRepository;

@CrossOrigin(origins = "*")
@RestController

public class convenioController {

	public static final Logger logger = LoggerFactory.getLogger(convenioController.class);

	@Autowired
	convenioRepository repository;

	// **MUÃ‰STRA TODAS LOS CONVENIOS EXISTENTES EN LA BASE DE DADTOS**

	@GetMapping("/convenio")
	public List<convenio> getAllConvenios() {
		System.out.println("Get all Convenios ...");

		List<convenio> convenio = new ArrayList<>();
		repository.findAll().forEach(convenio::add);

		return convenio;
	}

	// **MUÃ‰STRA UN CONVENIO ESPECÃ�FICA

	@GetMapping(value = "/convenio/{id}")
	public List<convenio> findById(@PathVariable int id) {

		List<convenio> convenio = repository.findById(id);
		return convenio;
	}

	// **CREA UNA NUEVO CONVENIO**

	@PostMapping(value = "/convenio")
	public convenio postConvenio(@RequestBody convenio Convenio) {
		convenio _convenio = repository.save(new convenio(Convenio.getId_tip_conve(),
				Convenio.getFecha_ini(), Convenio.getFecha_fin(), Convenio.getEstado(), Convenio.getCode(),
				Convenio.getUser_crea(), Convenio.getFecha_crea(), Convenio.getUsuario_mod(), Convenio.getFecha_mod()));
		return _convenio;
	}

	// **EDITA UN CONVENIO DE ACUERDO A SU ID**

	@PutMapping("/convenio/{id}")
	public ResponseEntity<convenio> updateConvenio(@PathVariable("id") Long id, @RequestBody convenio convenio) {
		System.out.println("Update convenio with ID = " + id + "...");
		Optional<convenio> convenioData = repository.findById(id);

		if (convenioData.isPresent()) {
			convenio _convenio = convenioData.get();
			_convenio.setId_tip_conve(convenio.getId_tip_conve());
			_convenio.setFecha_ini(convenio.getFecha_ini());
			_convenio.setFecha_fin(convenio.getFecha_fin());
			_convenio.setEstado(convenio.getEstado());
			_convenio.setUser_crea(convenio.getUser_crea());
			_convenio.setFecha_crea(convenio.getFecha_crea());
			_convenio.setUsuario_mod(convenio.getUsuario_mod());
			_convenio.setFecha_mod(convenio.getFecha_mod());

			return new ResponseEntity<>(repository.save(_convenio), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
