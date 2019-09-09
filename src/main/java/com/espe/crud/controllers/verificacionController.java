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

import com.espe.crud.model.verificacion;
import com.espe.crud.repository.verificacionRepository;



@CrossOrigin(origins = "*")
@RestController

public class verificacionController {
	
	  public static final Logger logger = LoggerFactory.getLogger(verificacionController.class);
	  
	  
	  @Autowired
	   verificacionRepository repository;
	  
	//**MUESTRA LAS VERIFICACIONES EXISTENTES EN LA BASE DE DADTOS**
	  
	  @GetMapping( "/verificacion")
	    public List<verificacion> getAllVerificaciones() {
    	System.out.println("Get all verificaciones...");
    	
	        List<verificacion> verificacion = new ArrayList<>();
	        repository.findAll().forEach(verificacion::add);
	        return verificacion;
	    }
	   
     //**MUESTRA UNA VERIFICACION ESPECIFICA 
	    
	    @GetMapping(value = "verificacion/{id}")
	    public List<verificacion> findById(@PathVariable int id) {
	   
	      List<verificacion> verificacion = repository.findById(id);
	      return verificacion;
	    }
	    
     //**CREA UNA  NUEVA VERIFICACION**
	    
	    @PostMapping(value = "/verificacion")
	    public verificacion postVerificacion(@RequestBody verificacion verificacion) {
	    	verificacion _verificacion = repository.save(new verificacion( verificacion.getId_requisito_pl(), verificacion.getId_requisito_submov(), verificacion.getPidm(), verificacion.getEstado(),
	    			                                                       verificacion.getCodigo_solicitud(), verificacion.getUsuario_crea(), verificacion.getFecha_crea(), verificacion.getUsuario_mod(), verificacion.getFecha_mod()));
	      return _verificacion;
	    }
	    
	 //**EDITA UNA VERIFICACION DE ACUERDO A SU ID**
	    
	    @PutMapping("/verificacion/{id}")
	    public ResponseEntity<verificacion> updateVerificacion(@PathVariable("id") 
	    Long id, @RequestBody verificacion verificacion) {
	      System.out.println("Update verificacion with ID = " + id + "...");
	      Optional<verificacion> verificacionData = repository.findById(id);
	   
	      if (verificacionData.isPresent()) {
	    	  verificacion _verificacion = verificacionData.get();
	    	  _verificacion.setId_requisito_pl(verificacion.getId_requisito_pl());
	    	  _verificacion.setId_requisito_submov(verificacion.getId_requisito_submov());
	    	  _verificacion.setPidm(verificacion.getPidm());
	    	  _verificacion.setEstado(verificacion.getEstado());	
	    	  _verificacion.setCodigo_solicitud(verificacion.getCodigo_solicitud());
	    	  _verificacion.setUsuario_crea(verificacion.getUsuario_crea());
	    	  _verificacion.setFecha_crea(verificacion.getFecha_crea());
	    	  _verificacion.setUsuario_mod(verificacion.getUsuario_mod());
	    	  _verificacion.setFecha_mod(verificacion.getFecha_mod());
	    	  

	        return new ResponseEntity<>(repository.save(_verificacion), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }

}
