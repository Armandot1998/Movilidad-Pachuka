package com.espe.crud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.espe.crud.model.movsubm;
import com.espe.crud.repository.movsubmRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class movsubmController {

	 @Autowired
	 movsubmRepository repository;
	 
	    //**MUESTRA TODAS LOS MOVBD EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/movsubm")
	    public List<movsubm> getAllMovsubm() {
	      System.out.println("Get all Movsubm ...");
	   
	      List<movsubm> movsubm = new ArrayList<>();
	      repository.findAll().forEach(movsubm::add);
	   
	      return movsubm;
	    }
	    
	    //**MUESTRA UN MOVBD ESPECÃ�FICA 
	    
	    @GetMapping(value = "movsubm/{id}")
	    public List<movsubm> findById(@PathVariable int id) {
	   
	      List<movsubm> movsubm = repository.findById(id);
	      return movsubm;
	    }
	    
	    //**CREA UNA NUEVO CONVENIO**
		 @CrossOrigin("*")	 		    
		    @PostMapping(value = "/movsubm")
		    public movsubm postGestinv(@RequestBody movsubm movsubm) {
		    	movsubm _movsubm = repository.save(new movsubm(movsubm.getId(), movsubm.getNombre(),
		    	movsubm.getUsuario_crea(), movsubm.getfecha_crea(), movsubm.getUsuario_mod(), 
		    	movsubm.getFecha_mod()));
		      return _movsubm;
		    }
		 
		    @PutMapping("/movsubm/{id}")
		    public ResponseEntity<movsubm> updateMovsubm(@PathVariable("id") 
		    Long id, @RequestBody movsubm movsubm) {
		      System.out.println("Update movsubm with ID = " + id + "...");
		      Optional<movsubm> movsubmData = repository.findById(id);
		   
		      if (movsubmData.isPresent()) {
		    	  movsubm _movsubm = movsubmData.get();
		        _movsubm.setId(movsubm.getId());
		        _movsubm.setNombre(movsubm.getNombre());
		        _movsubm.setUsuario_crea(movsubm.getUsuario_crea());
		        _movsubm.setFecha_crea(movsubm.getfecha_crea());
		        _movsubm.setUsuario_mod(movsubm.getUsuario_mod());
		        _movsubm.setFecha_mod(movsubm.getFecha_mod());
		        return new ResponseEntity<>(repository.save(_movsubm), HttpStatus.OK);
		      } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		    }
}
