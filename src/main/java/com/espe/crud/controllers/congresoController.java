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

import com.espe.crud.model.Congreso;
import com.espe.crud.repository.congresoRepository;

@CrossOrigin(origins = "*")
@RestController
public class congresoController {


    public static final Logger logger = LoggerFactory.getLogger(congresoController.class);

    @Autowired
    congresoRepository repository;
    
    //**MUÃ‰STRA TODAS LOS CONGRESOS EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/congresos")
    public List<Congreso> getAllCongresos() {
      System.out.println("Get all Congresos ...");
   
      List<Congreso> congreso = new ArrayList<>();
      repository.findAll().forEach(congreso::add);
   
      return congreso;
    }
    
    //**MUÃ‰STRA UN CONGRESO ESPECÃ�FICO
    
    @GetMapping(value = "congreso/{id}")
    public List<Congreso> findById(@PathVariable int id) {
   
      List<Congreso> congreso = repository.findById(id);
      return congreso;
    }

    //**CREA UN NUEVO CONGRESO**
    
    @PostMapping(value = "/congreso")
    public Congreso postCongreso(@RequestBody Congreso Congreso) {
      Congreso _congreso = repository.save(new Congreso( Congreso.getId(), Congreso.getNombre(), Congreso.getSitio_web(), 
      Congreso.getNom_cont(), Congreso.getTelf(), Congreso.getEmail(), Congreso.getFech_ini(), Congreso.getFech_fin(), 
      Congreso.getUsuario_crea(), Congreso.getFech_crea(), Congreso.getUsuario_mod(), Congreso.getFech_mod()));
      return _congreso;
    }
    
    //**EDITA UN CONGRESO DE ACUERDO A SU ID**
    
    @PutMapping("/congreso/{id}")
    public ResponseEntity<Congreso> updateCongreso(@PathVariable("id") 
    Long id, @RequestBody Congreso congreso) {
      System.out.println("Update congreso with ID = " + id + "...");
      Optional<Congreso> congresoData = repository.findById(id);
   
      if (congresoData.isPresent()) {
        Congreso _congreso = congresoData.get();
        _congreso.setNombre(congreso.getNombre());
        _congreso.setSitio_web(congreso.getSitio_web());
        _congreso.setNom_cont(congreso.getNom_cont());
        _congreso.setTelf(congreso.getTelf());
        _congreso.setEmail(congreso.getEmail());
        _congreso.setFech_ini(congreso.getFech_ini());
        _congreso.setFech_fin(congreso.getFech_fin());
        _congreso.setUsuario_crea(congreso.getUsuario_crea());
        _congreso.setFech_crea(congreso.getFech_crea());
        _congreso.setUsuario_mod(congreso.getUsuario_mod());
        _congreso.setFech_mod(congreso.getFech_mod());
        
        return new ResponseEntity<>(repository.save(_congreso), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

}
