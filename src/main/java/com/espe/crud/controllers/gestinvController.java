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

import com.espe.crud.model.gestinv;
import com.espe.crud.repository.gestinvRepository;






@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class gestinvController {


	    public static final Logger logger = LoggerFactory.getLogger(gestinvController.class);

	    @Autowired
	    gestinvRepository repository;
	    
	    //**MUÃ‰STRA TODAS LOS GESTINV EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/gestinv")
	    public List<gestinv> getAllGestinv() {
	      System.out.println("Get all Gestinvs ...");
	   
	      List<gestinv> gestinv = new ArrayList<>();
	      repository.findAll().forEach(gestinv::add);
	   
	      return gestinv;
	    }
	    
	    //**MUÃ‰STRA UN GESTINV ESPECÃ�FICO
	    
	    @GetMapping(value = "/gestinv/{id}")
	    public List<gestinv> findById(@PathVariable int id) {
	   
	      List<gestinv> gestinv = repository.findById(id);
	      return gestinv;
	    }

	    //**CREA UNA NUEVO GESTINV**
	    
	    @PostMapping(value = "/gestinv")
	    public gestinv postGestinv(@RequestBody gestinv gestinv) {
	    	gestinv _gestinv = repository.save(new gestinv(gestinv.getId_solictmov(), 
	    	gestinv.getObj(), gestinv.getConvenio(), gestinv.getP_cooper(), gestinv.getA_colab(), 
	    	gestinv.getNom_inst(), gestinv.getSit_web_isnt(), gestinv.getNom_c_inst(), gestinv.getTelf_c_inst(),
	    	gestinv.getEmail_c_inst(), gestinv.getFech_ini(), gestinv.getFech_fin(), gestinv.getUsuario_crea(), 
	    	gestinv.getFecha_crea(), gestinv.getUsuario_mod(), gestinv.getFecha_mod()));
	      return _gestinv;
	    }
	    
	    //**EDITA UN GESTINV DE ACUERDO A SU ID**
	    
	    @PutMapping("/gestinv/{id}")
	    public ResponseEntity<gestinv> updateGestinv(@PathVariable("id") 
	    Long id, @RequestBody gestinv gestinv) {
	      System.out.println("Update gestinv with ID = " + id + "...");
	      Optional<gestinv> gestinvData = repository.findById(id);
	   
	      if (gestinvData.isPresent()) {
	    	  gestinv _gestinv = gestinvData.get();
	        _gestinv.setId_solictmov(gestinv.getId_solictmov());
	        _gestinv.setObj(gestinv.getObj());
	        _gestinv.setConvenio(gestinv.getConvenio());
	        _gestinv.setP_cooper(gestinv.getP_cooper());
	        _gestinv.setA_colab(gestinv.getA_colab());
	        _gestinv.setNom_inst(gestinv.getNom_inst());
	        _gestinv.setSit_web_isnt(gestinv.getSit_web_isnt());
	        _gestinv.setNom_c_inst(gestinv.getNom_c_inst());
	        _gestinv.setTelf_c_inst(gestinv.getTelf_c_inst());
	        _gestinv.setEmail_c_inst(gestinv.getEmail_c_inst());
	        _gestinv.setFech_fin(gestinv.getFech_fin());
	        _gestinv.setFech_ini(gestinv.getFech_ini());
	        _gestinv.setUsuario_crea(gestinv.getUsuario_crea());
	        _gestinv.setFecha_crea(gestinv.getFecha_crea());
	        _gestinv.setUsuario_mod(gestinv.getUsuario_mod());
	      
	        return new ResponseEntity<>(repository.save(_gestinv), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }

}
