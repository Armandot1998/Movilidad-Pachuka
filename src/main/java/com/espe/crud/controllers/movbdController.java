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

import com.espe.crud.model.movbd;
import com.espe.crud.repository.movbdRepository;
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class movbdController {


	    public static final Logger logger = LoggerFactory.getLogger(movbdController.class);

	    @Autowired
	    movbdRepository repository;
	    
	    //**MUESTRA TODAS LOS MOVBD EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/movbd")
	    public List<movbd> getAllMovbd() {
	      System.out.println("Get all Movbds ...");
	   
	      List<movbd> movbd = new ArrayList<>();
	      repository.findAll().forEach(movbd::add);
	   
	      return movbd;
	    }
	    
	    //**MURESTRA UN MOVBD ESPECIFICA 
	    
	    @GetMapping(value = "/movbd/{id}")
	    public List<movbd> findById(@PathVariable int id) {
	   
	      List<movbd> movbd = repository.findById(id);
	      return movbd;
	    }

	    //**CREA UNA NUEVO CONVENIO**
	    
	    @PostMapping(value = "/movbd")
	    public movbd postGestinv(@RequestBody movbd movbd) {
	    	movbd _movbd = repository.save(new movbd( movbd.getId_convo(), movbd.getNombre(), 
	    	movbd.getNom_f_impac(), movbd.getUsuario_crea(), movbd.getFecha_crea(), movbd.getUsuario_mod(), 
	    	movbd.getFecha_mod()));
	      return _movbd;
	    }
	    
	    //**EDITA UN CONVENIO DE ACUERDO A SU ID**
	    
	    @PutMapping("/movbd/{id}")
	    public ResponseEntity<movbd> updateMovbd(@PathVariable("id") 
	    Long id, @RequestBody movbd movbd) {
	      System.out.println("Update gestinv with ID = " + id + "...");
	      Optional<movbd> movbdData = repository.findById(id);
	   
	      if (movbdData.isPresent()) {
	    	  movbd _movbd = movbdData.get();
	        _movbd.setId_convo(movbd.getId_convo());
	        _movbd.setNombre(movbd.getNombre());
	        _movbd.setNom_f_impac(movbd.getNom_f_impac());
	        _movbd.setUsuario_crea(movbd.getUsuario_crea());
	        _movbd.setFecha_crea(movbd.getFecha_crea());
	        _movbd.setUsuario_mod(movbd.getUsuario_mod());
	        _movbd.setFecha_mod(movbd.getFecha_mod());

	      
	        return new ResponseEntity<>(repository.save(_movbd), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }
}