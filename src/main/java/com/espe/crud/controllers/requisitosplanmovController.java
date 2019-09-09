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

import com.espe.crud.model.requisitosplanmov;
import com.espe.crud.repository.requisitosplanmovRepository;



@CrossOrigin(origins = "*")
@RestController

public class requisitosplanmovController {


	    public static final Logger logger = LoggerFactory.getLogger(requisitosplanmovController.class);

	    
	   
	    @Autowired
	    requisitosplanmovRepository repository;
	    
	  //**MUESTRA LOS REQUISITOS DE PLAN DEL MOVILIDAD EXISTENTES EN LA BASE DE DADTOS**
		  
		  @GetMapping( "/requisitosplanmov")
		    public List<requisitosplanmov> getAllRequisitosplanmov() {
	    	System.out.println("Get all requisitos del plan de movilidad...");
	    	
		        List<requisitosplanmov> requisitosplanmov = new ArrayList<>();
		        repository.findAll().forEach(requisitosplanmov::add);
		        return requisitosplanmov;
		    }
	      
	  
	    
	  //**MUESTRA UN REQUISITO DEL PLAN DE MOVILIDAD ESPECIFICA 
		    
		    @GetMapping(value = "requisitosplanmov/{id}")
		    public List<requisitosplanmov> findById(@PathVariable int id) {
		   
		      List<requisitosplanmov> requisitosplanmov = repository.findById(id);
		      return requisitosplanmov;
		    }
	   
	    
	 //**CREA UN NUEVO REQUISITO DEL PLAN DE MOVILIDAD**
		    
		    @PostMapping(value = "/requisitosplanmov")
		    public requisitosplanmov postRequisitosplanmov(@RequestBody requisitosplanmov requisitosplanmov) {
		    	requisitosplanmov _requisitosplanmov = repository.save(new requisitosplanmov(requisitosplanmov.getUsuario_crea(), requisitosplanmov.getFecha_crea(), 
		    															requisitosplanmov.getUsuario_mod(), requisitosplanmov.getFecha_mod(),requisitosplanmov.getRequisito(),requisitosplanmov.getId_plan_id()));
		      return _requisitosplanmov;
		    }
		    
		    
    //**EDITA UNA REQUISITO DEL PLAN DE MOVILIDAD DE ACUERDO A SU ID**
		    
		    @PutMapping("/requisitosplanmov/{id}")
		    public ResponseEntity<requisitosplanmov> updateRequisitosplanmov(@PathVariable("id") 
		    Long id, @RequestBody requisitosplanmov requisitosplanmov) {
		      System.out.println("Update requisito del plan de movilidad with ID = " + id + "...");
		      Optional<requisitosplanmov> requisitosplanmovData = repository.findById(id);
		   
		      if (requisitosplanmovData.isPresent()) {
		    	  requisitosplanmov _requisitosplanmov = requisitosplanmovData.get();
		    	  	
		    	  _requisitosplanmov.setUsuario_crea(requisitosplanmov.getUsuario_crea());
		    	  _requisitosplanmov.setFecha_crea(requisitosplanmov.getFecha_crea());
		    	  _requisitosplanmov.setUsuario_mod(requisitosplanmov.getUsuario_mod());
		    	  _requisitosplanmov.setFecha_mod(requisitosplanmov.getFecha_mod());
		    	  _requisitosplanmov.setRequisito(requisitosplanmov.getRequisito());
		    	  _requisitosplanmov.setId_plan_id(requisitosplanmov.getId_plan_id());
		    	  

		        return new ResponseEntity<>(repository.save(_requisitosplanmov), HttpStatus.OK);
		      } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		    }  
		    
}
