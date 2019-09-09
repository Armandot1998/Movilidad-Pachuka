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

import com.espe.crud.model.cargdoc;
import com.espe.crud.repository.cargdocRepository;





@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class cargdocController {


	    public static final Logger logger = LoggerFactory.getLogger(cargdocController.class);


	    
	    @Autowired
	    cargdocRepository repository;
	    
	    //**MUESTRA TODOS LOS DOCUMENTOS CARGADOS EN LA BASE DE DADTOS**
	    
	    @GetMapping("/cargdoc")
	    public List<cargdoc> getAllCargdoc() {
	      System.out.println("Get all Cargdoc ...");
	   
	      List<cargdoc> cargdoc = new ArrayList<>();
	      repository.findAll().forEach(cargdoc::add);
	   
	      return cargdoc;
	    }
	    
	    //**MUESTRA UN DOCUMENTO CARGADO EN ESPECÃ�FICO
	    
	    @GetMapping(value = "cargdoc/{id}")
	    public List<cargdoc> findById(@PathVariable long id) {
	   
	      List<cargdoc> cargdoc = repository.findById(id);
	      return cargdoc;
	    }

	    //**CARGA UN NUEVO DOCUMENTO**
	    
	    @PostMapping(value = "/cargdoc")
	    public cargdoc postCargdoc(@RequestBody cargdoc Cargdoc) {
	      cargdoc _cargdoc = repository.save(new cargdoc(Cargdoc.getId_tip_doc(),
	      Cargdoc.getId_fmovilidad(), Cargdoc.getId_externo(), Cargdoc.getId_gestinv(), Cargdoc.getId_testinter(), 
	      Cargdoc.getTipdoc_ruta(), Cargdoc.getUsuario_crea(), Cargdoc.getFecha_crea(), Cargdoc.getUsuario_mod(), 
	      Cargdoc.getFecha_mod()));
	      return _cargdoc;
	    }
	    
	    //**EDITA UN DOCUMENTO CARGADO DE ACUERDO A SU ID**
	    
	    @PutMapping("/cargdoc/{id}")
	    public ResponseEntity<cargdoc> updateCargdoc(@PathVariable("id") 
	    Long id, @RequestBody cargdoc cargdoc) {
	      System.out.println("Update cargdoc with ID = " + id + "...");
	      Optional<cargdoc> cargdocData = repository.findById(id);
	   
	      if (cargdocData.isPresent()) {
	        cargdoc _cargdoc = cargdocData.get();
	        _cargdoc.setId_tip_doc(cargdoc.getId_tip_doc());
	        _cargdoc.setId_fmovilidad(cargdoc.getId_fmovilidad());
	        _cargdoc.setId_externo(cargdoc.getId_externo());
	        _cargdoc.setId_gestinv(cargdoc.getId_gestinv());
	        _cargdoc.setId_testinter(cargdoc.getId_testinter());
	        _cargdoc.setTipdoc_ruta(cargdoc.getTipdoc_ruta());
	        _cargdoc.setUsuario_crea(cargdoc.getUsuario_crea());
	        _cargdoc.setFecha_crea(cargdoc.getFecha_crea());
	        _cargdoc.setUsuario_mod(cargdoc.getUsuario_mod());
	        _cargdoc.setFecha_mod(cargdoc.getFecha_mod());
	        
	        return new ResponseEntity<>(repository.save(_cargdoc), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }
	  	
}
