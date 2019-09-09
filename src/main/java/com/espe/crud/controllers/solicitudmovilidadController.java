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

import com.espe.crud.model.solicitudmovilidad;
import com.espe.crud.repository.solicitudmovilidadRepository;


@CrossOrigin(origins = "*")
@RestController
public class solicitudmovilidadController {

	 public static final Logger logger = LoggerFactory.getLogger(solicitudmovilidadController.class); 
	 
	 @Autowired
	 solicitudmovilidadRepository repository;	  
	  
	//**MUESTRA TODAS LAS SOLICITUDES DE MOVILIDAD EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/smovilidad")
	    public List<solicitudmovilidad> getAllSolicitudmovilidad() {
	      System.out.println("Get all solicitud de movilidad ...");
	   
	      List<solicitudmovilidad> solicitudmovilidad = new ArrayList<>();
	      repository.findAll().forEach(solicitudmovilidad::add);
	   
	      return solicitudmovilidad;
	    }
	    
	    //**MUESTRA UNA SOLICITUD DE MOVILIDAD  ESPECIFICA 
	    
	    @GetMapping(value = "/smovilidad/{id}")
	    public List<solicitudmovilidad> findById(@PathVariable int id) {
	   
	      List<solicitudmovilidad> solicitudmovilidad = repository.findById(id);
	      return solicitudmovilidad;
	    }
	 
	    //**CREA UNA NUEVA CONVOCATORIA**
	    
	    @PostMapping(value = "/smovilidad")
	    public solicitudmovilidad postSolicitudmovilidad(@RequestBody solicitudmovilidad smovilidad) {
	    	solicitudmovilidad _solicitudmovilidad = repository.save(new solicitudmovilidad(
	    			smovilidad.getId_verif_req(), smovilidad.getEstado(), smovilidad.getObser(), smovilidad.getFecha_solicitud(), 
	    			smovilidad.getUsuario_crea(),smovilidad.getFecha_crea(), smovilidad.getUsuario_mod(),smovilidad.getFecha_mod()));
	     
	    	return _solicitudmovilidad;
	    }
	    
	    //**EDITA UNA SOLICITUD DE MOVILIDAD  DE ACUERDO A SU ID**
	    
	    @PutMapping("/smovilidad/{id}")
	    public ResponseEntity<solicitudmovilidad> updateConvocatoria(@PathVariable("id") 
	    Long id, @RequestBody solicitudmovilidad solicitudmovilidad) {
	      System.out.println("Update solicitud de movilidad  with ID = " + id + "...");
	      Optional<solicitudmovilidad> solicitudmovilidadData = repository.findById(id);
	   
	      if (solicitudmovilidadData.isPresent()) {
	    	  solicitudmovilidad _solicitudmovilidad = solicitudmovilidadData.get();
	    	  _solicitudmovilidad.setId_verif_req(solicitudmovilidad.getId_verif_req());
	    	  _solicitudmovilidad.setEstado(solicitudmovilidad.getEstado());
	    	  _solicitudmovilidad.setObser(solicitudmovilidad.getObser());
	    	  _solicitudmovilidad.setFecha_solicitud(solicitudmovilidad.getFecha_solicitud());
	    	  _solicitudmovilidad.setUsuario_crea(solicitudmovilidad.getUsuario_crea());
	    	  _solicitudmovilidad.setFecha_crea(solicitudmovilidad.getFecha_crea());
	    	  _solicitudmovilidad.setUsuario_mod(solicitudmovilidad.getUsuario_mod());
	    	  _solicitudmovilidad.setFecha_mod(solicitudmovilidad.getFecha_mod());
	        
	        return new ResponseEntity<>(repository.save(_solicitudmovilidad), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }
	   
		
}
