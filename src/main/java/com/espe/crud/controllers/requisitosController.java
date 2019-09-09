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

import com.espe.crud.model.requisitos;
import com.espe.crud.repository.requisitosRepository;

@CrossOrigin(origins = "*")
@RestController
public class requisitosController {

    public static final Logger logger = LoggerFactory.getLogger(requisitosController.class);

    @Autowired
    requisitosRepository repository;
    
    //**MUÃ‰STRA TODAS LOS REQUISITOS EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/requisito")
    public List<requisitos> getAllRequisitos() {
      System.out.println("Get all Requisitos ...");
   
      List<requisitos> requisitos = new ArrayList<>();
      repository.findAll().forEach(requisitos::add);
   
      return requisitos;
    }
    
    //**MUÃ‰STRA UN REQUISITO ESPECÃ�FICO 
    
    @GetMapping(value = "/requisitos/{id}")
    public List<requisitos> findById(@PathVariable int id) {
   
      List<requisitos> requisitos = repository.findById(id);
      return requisitos;
    }

    //**CREA UNA NUEVO REQUISITO**
    
    @PostMapping(value = "/requisitos")
    public requisitos postRequisitos(@RequestBody requisitos requisitos) {
    	requisitos _requisitos = repository.save(new requisitos( requisitos.getNombre(), 
    	requisitos.getDetalle(), requisitos.getEstado(), requisitos.getUsuario_crea(), requisitos.getFecha_crea(), 
    	requisitos.getUsuario_mod(), requisitos.getFecha_mod()));
      return _requisitos;
    }
    
    //**EDITA UN REQUISITO DE ACUERDO A SU ID**
    
    @PutMapping("/requisitos/{id}")
    public ResponseEntity<requisitos> updateRequisitos(@PathVariable("id") 
    Long id, @RequestBody requisitos requisitos) {
      System.out.println("Update requisitos with ID = " + id + "...");
      Optional<requisitos> requisitosData = repository.findById(id);
   
      if (requisitosData.isPresent()) {
    	  requisitos _requisitos = requisitosData.get();
        _requisitos.setNombre(requisitos.getNombre());
        _requisitos.setDetalle(requisitos.getDetalle());
        _requisitos.setEstado(requisitos.getEstado());
        _requisitos.setUsuario_crea(requisitos.getUsuario_crea());
        _requisitos.setFecha_crea(requisitos.getFecha_crea());
        _requisitos.setUsuario_mod(requisitos.getUsuario_mod());
        _requisitos.setFecha_mod(requisitos.getFecha_mod());
      
        return new ResponseEntity<>(repository.save(_requisitos), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}