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

import com.espe.crud.model.PlanMovilidad;
import com.espe.crud.repository.planmovilidadrepository;

@CrossOrigin(origins = "*")
@RestController
public class PlanMovilidadController {


    public static final Logger logger = LoggerFactory.getLogger(PlanMovilidadController.class);

    @Autowired
    planmovilidadrepository repository;
    
    //**MUÃ‰STRA TODAS LOS PLANES DE MOVILIDAD EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/PlanMovilidad")
    public List<PlanMovilidad> getAllPlanMovilidad() {
      System.out.println("Get all PlanMovilidads ...");
   
      List<PlanMovilidad> PlanMovilidad = new ArrayList<>();
      repository.findAll().forEach(PlanMovilidad::add);
   
      return PlanMovilidad;
    }
    
    //**MUÃ‰STRA UN PLAN DE MOVILIDAD ESPECÃ�FICA 
    
    @GetMapping(value = "/PlanMovilidad/{id}")
    public List<PlanMovilidad> findById(@PathVariable int id) {
   
      List<PlanMovilidad> PlanMovilidad = repository.findById(id);
      return PlanMovilidad;
    }

    //**CREA UNA NUEVO PLAN DE MOVILIDAD**
    
    @PostMapping(value = "/PlanMovilidad")
    public PlanMovilidad postPlanMovilidad(@RequestBody PlanMovilidad PlanMovilidad) {
    	PlanMovilidad _PlanMovilidad = repository.save(new PlanMovilidad( 
    	PlanMovilidad.getId_tipmov(), PlanMovilidad.getNombre(), PlanMovilidad.getUsuario_crea(), 
    	PlanMovilidad.getFecha_crea(), PlanMovilidad.getUsuario_mod(), PlanMovilidad.getFecha_mod()));
      return _PlanMovilidad;
    }
    
    //**EDITA UN PLAN DE MOVILIDAD DE ACUERDO A SU ID**
    
    @PutMapping("/PlanMovilidad/{id}")
    public ResponseEntity<PlanMovilidad> updatePlanMovilidad(@PathVariable("id") 
    Long id, @RequestBody PlanMovilidad PlanMovilidad) {
      System.out.println("Update PlanMovilidad with ID = " + id + "...");
      Optional<PlanMovilidad> PlanMovilidadData = repository.findById(id);
   
      if (PlanMovilidadData.isPresent()) {
    	  PlanMovilidad _PlanMovilidad = PlanMovilidadData.get();
        _PlanMovilidad.setId_tipmov(PlanMovilidad.getId_tipmov());
        _PlanMovilidad.setNombre(PlanMovilidad.getNombre());
        _PlanMovilidad.setUsuario_crea(PlanMovilidad.getUsuario_crea());
        _PlanMovilidad.setFecha_crea(PlanMovilidad.getFecha_crea());
        _PlanMovilidad.setUsuario_mod(PlanMovilidad.getUsuario_mod());
        _PlanMovilidad.setFecha_mod(PlanMovilidad.getFecha_mod());

      
        return new ResponseEntity<>(repository.save(_PlanMovilidad), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
