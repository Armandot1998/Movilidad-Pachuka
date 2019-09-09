package com.espe.crud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.espe.crud.model.Cronograma;
import com.espe.crud.repository.cronogramaRepository;

@CrossOrigin(origins = "*")
@RestController
public class cronogramaController {
	public static final Logger logger = LoggerFactory.getLogger(externoController.class);


    @Autowired
    cronogramaRepository repository;
    
    
    @GetMapping("/cronograma")
    public List<Cronograma> getAllCronogramas() {
      System.out.println("Get all Cronogramas ...");
   
      List<Cronograma> cronograma = new ArrayList<>();
      repository.findAll().forEach(cronograma::add);
   
      return cronograma;
    }
    
    //**MUÃ‰STRA UN D.EXTERNO ESPECÃ�FICO 
    
    @GetMapping(value = "cronograma/{id}")
    public List<Cronograma> findById(@PathVariable int id) {
   
      List<Cronograma> cronograma = repository.findById(id);
      return cronograma;
    }
    
    //**CREA UNA NUEVO D.EXTERNO**
    
    @PostMapping(value = "/cronograma")
    public Cronograma postCronograma(@RequestBody Cronograma cronograma) {
      Cronograma _cronograma = repository.save(new Cronograma(cronograma.getId(), cronograma.getId_externo(), cronograma.getLugar(), 
      cronograma.getFecha(), cronograma.getActiv(), cronograma.getUsuario_crea(), cronograma.getFecha_crea(), cronograma.getUsuario_mod(), cronograma.getFecha_mod()));
      return _cronograma;
    }
}
