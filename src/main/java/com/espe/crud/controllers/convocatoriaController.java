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

import com.espe.crud.model.convocatoria;
import com.espe.crud.repository.convocatoriaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class convocatoriaController {


	    public static final Logger logger = LoggerFactory.getLogger(convocatoriaController.class);

	    @Autowired
	    convocatoriaRepository repository;
	    
	    //**MUESTRA TODAS LAS CONVOCATORIAS EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/convocatoria")
	    public List<convocatoria> getAllConvocatorias() {
	      System.out.println("Get all Convocatorias ...");
	   
	      List<convocatoria> convocatoria = new ArrayList<>();
	      repository.findAll().forEach(convocatoria::add);
	   
	      return convocatoria;
	    }
	    
	    //**MUESTRA UNA CONVOCATORIA ESPECIFICA 
	    
	    @GetMapping(value = "/convocatoria/{id}")
	    public List<convocatoria> findById(@PathVariable int id) {
	   
	      List<convocatoria> convocatoria = repository.findById(id);
	      return convocatoria;
	    }

	    //**CREA UNA NUEVA CONVOCATORIA**
	    
	    @PostMapping(value = "/convocatoria")
	    public convocatoria postConvocatoria(@RequestBody convocatoria Convo) {
	      convocatoria _convocatoria = repository.save(new convocatoria(Convo.getDescripcion(), 
	    		  Convo.getFecha_fin(), Convo.getFecha_inicio(), Convo.getEstado()));
	      return _convocatoria;
	    }
	    
	    //**EDITA UNA CONVOCATORIA DE ACUERDO A SU ID**
	    
	    @PutMapping("/convocatoria/{id}")
	    public ResponseEntity<convocatoria> updateConvocatoria(@PathVariable("id") 
	    Long id, @RequestBody convocatoria convocatoria) {
	      System.out.println("Update convocatoria with ID = " + id + "...");
	      Optional<convocatoria> convocatoriaData = repository.findById(id);
	   
	      if (convocatoriaData.isPresent()) {
	        convocatoria _convocatoria = convocatoriaData.get();
	        _convocatoria.setDescripcion(convocatoria.getDescripcion());
	        _convocatoria.setFecha_fin(convocatoria.getFecha_fin());
	        _convocatoria.setFecha_inicio(convocatoria.getFecha_inicio());
	        _convocatoria.setEstado(convocatoria.getEstado());
	        return new ResponseEntity<>(repository.save(_convocatoria), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }
	  	
}