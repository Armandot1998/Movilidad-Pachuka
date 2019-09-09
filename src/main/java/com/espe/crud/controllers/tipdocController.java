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

import com.espe.crud.model.tipdoc;
import com.espe.crud.repository.tipdocRepository;




@CrossOrigin(origins = "*")
@RestController

public class tipdocController {


	    public static final Logger logger = LoggerFactory.getLogger(tipdocController.class);


	    @Autowired
	    tipdocRepository repository;
	      
	    //**MUESTRA TODAS LOS TIPOS DE DOCUMENTOS EN LA BASE DE DADTOS**
    
	    @GetMapping(  "/tipdoc")
	    public List<tipdoc> getAllTipdocs() {
	    	System.out.println("Get all Tipos de documentos ...");
	    	
	        List<tipdoc> tipdoc = new ArrayList<>();
	        return tipdoc;
	    }  
	     
	  
	    //**MUESTRA UN TIPO DE DOCUMENTO ESPECIFICA 
	    @GetMapping(value ="/tipdoc/{id}")
	    public List<tipdoc> findById(@PathVariable long id) {
	    	
	    	List<tipdoc> tipdoc = repository.findById(id);
	        return tipdoc;
	    }
	    

	    //**CREA UN NUEVO TIPO DE DOCUMENTO**
	    
	    @PostMapping(value = "/tipdoc")
	    public tipdoc postTipdoc(@RequestBody tipdoc tipodoc) {
	    	tipdoc _tipdoc = repository.save(new tipdoc(
	    			tipodoc.getNom_doc(), tipodoc.getEstado(), tipodoc.getUsuario_crea(), tipodoc.getFecha_crea(),
	    			tipodoc.getUsuario_mod(),tipodoc.getFecha_mod()));
	      return _tipdoc;
	    }
	    
	   
	    //**EDITA UN NUEVO TIPO DE DOCUMENTO DE ACUERDO A SU ID**
	    
	    @PutMapping("/tipdoc/{id}")
	    public ResponseEntity<tipdoc> updateTipdoc(@PathVariable("id") 
	    Long id, @RequestBody tipdoc tipdoc) {
	      System.out.println("Update Tipo de documento with ID = " + id + "...");
	      Optional<tipdoc> tipdocData = repository.findById(id);
	   
	      if (tipdocData.isPresent()) {
	    	  tipdoc _tipdoc = tipdocData.get();
	    	  _tipdoc.setNom_doc(tipdoc.getNom_doc());
	    	  _tipdoc.setEstado(tipdoc.getEstado());
	    	  _tipdoc.setUsuario_crea(tipdoc.getUsuario_crea());
	    	  _tipdoc.setFecha_crea(tipdoc.getFecha_crea());
	    	  _tipdoc.setUsuario_mod(tipdoc.getUsuario_mod());
	    	  _tipdoc.setFecha_mod(tipdoc.getFecha_mod());
	        
	        
	        return new ResponseEntity<>(repository.save(_tipdoc), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }
	    
	    
}
