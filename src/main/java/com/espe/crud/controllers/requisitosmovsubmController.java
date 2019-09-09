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

import com.espe.crud.model.requisitosmovsubm;
import com.espe.crud.repository.requisitosmovsubmRepository;

@CrossOrigin(origins = "*")
@RestController
public class requisitosmovsubmController {

    public static final Logger logger = LoggerFactory.getLogger(requisitosmovsubmController.class);

    @Autowired
    requisitosmovsubmRepository repository;
    
    //**MUESTRA TODAS LOS REQUISITOSMOVSUBM EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/requisitosmovsubm")
    public List<requisitosmovsubm> getAllRequisitosmovsubm() {
      System.out.println("Get all Requisitosmovsubms ...");
   
      List<requisitosmovsubm> requisitosmovsubm = new ArrayList<>();
      repository.findAll().forEach(requisitosmovsubm::add);
   
      return requisitosmovsubm;
    }
    
    //**MUESTRA UN REQUISITOSUBM ESPECÃ�FICO 
    
    @GetMapping(value = "requisitosmovsubm/{id}")
    public List<requisitosmovsubm> findById(@PathVariable int id) {
   
      List<requisitosmovsubm> requisitosmovsubm = repository.findById(id);
      return requisitosmovsubm;
    }

    //**CREA UNA NUEVO REQUISITO**
    
    @PostMapping(value = "/requisitosmovsubm")
    public requisitosmovsubm postRequisitos(@RequestBody requisitosmovsubm requisitosmovsubm) {
    	requisitosmovsubm _requisitosmovsubm = repository.save(new requisitosmovsubm( 
    	requisitosmovsubm.getId_requisito(), requisitosmovsubm.getId_movsubm(), requisitosmovsubm.getUsuario_crea(), requisitosmovsubm.getFecha_crea(), 
    	requisitosmovsubm.getUsuario_mod(), requisitosmovsubm.getFecha_mod()));
      return _requisitosmovsubm;
    }
    
    //**EDITA UN REQUISITOSMOVSUBM DE ACUERDO A SU ID**
    
    @PutMapping("/requisitosmovsubm/{id}")
    public ResponseEntity<requisitosmovsubm> updateRequisitos(@PathVariable("id") 
    Long id, @RequestBody requisitosmovsubm requisitosmovsubm) {
      System.out.println("Update requisitosmovsubm with ID = " + id + "...");
      Optional<requisitosmovsubm> requisitosmovsubmData = repository.findById(id);
   
      if (requisitosmovsubmData.isPresent()) {
    	  requisitosmovsubm _requisitosmovsubm = requisitosmovsubmData.get();
        _requisitosmovsubm.setId_movsubm(requisitosmovsubm.getId_movsubm());
        _requisitosmovsubm.setId_requisito(requisitosmovsubm.getId_requisito());
        _requisitosmovsubm.setUsuario_crea(requisitosmovsubm.getUsuario_crea());
        _requisitosmovsubm.setFecha_crea(requisitosmovsubm.getFecha_crea());
        _requisitosmovsubm.setUsuario_mod(requisitosmovsubm.getUsuario_mod());
        _requisitosmovsubm.setFecha_mod(requisitosmovsubm.getFecha_mod());
      
        return new ResponseEntity<>(repository.save(_requisitosmovsubm), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
