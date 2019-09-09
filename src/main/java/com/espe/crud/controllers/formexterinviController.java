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

import com.espe.crud.model.formexterinvi;
import com.espe.crud.repository.formexterinviRepository;





@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class formexterinviController {


    public static final Logger logger = LoggerFactory.getLogger(formexterinviController.class);


    @Autowired
    formexterinviRepository repository;
    
    //**MUÃ‰STRA TODOS LOS F.EXTERNOS EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/formexterinvi")
    public List<formexterinvi> getAllFormexterinvi() {
      System.out.println("Get all Financiamientos ...");
   
      List<formexterinvi> formexterinvi = new ArrayList<>();
      repository.findAll().forEach(formexterinvi::add);
   
      return formexterinvi;
    }
    
    //**MUÃ‰STRA UN F.EXTERNO ESPECÃ�FICO 
    
    @GetMapping(value = "formexterinvi/{id}")
    public List<formexterinvi> findById(@PathVariable int id) {
   
      List<formexterinvi> formexterinvi = repository.findById(id);
      return formexterinvi;
    }

    //**CREA UNA NUEVO D.EXTERNO**
    
    @PostMapping(value = "/formexterinvi")
    public formexterinvi postFormexterinvi(@RequestBody formexterinvi formexterinvi) {
    	formexterinvi _formexterinvi = repository.save(new formexterinvi(
        formexterinvi.getId_convenio(), formexterinvi.getId_cronog(), 
    	formexterinvi.getId_lugar(), formexterinvi.getId_solitmov(), formexterinvi.getAntecedentes(),
    	formexterinvi.getObj(), formexterinvi.getFecha_ini(), formexterinvi.getFecha_fin(), 
    	formexterinvi.getMeta(), formexterinvi.getEntreg(), formexterinvi.getNom_cont(),
    	formexterinvi.getTelf_cont(), formexterinvi.getEmail_cont(), formexterinvi.getNom_doctora(), 
    	formexterinvi.getNom_tesis(), formexterinvi.getNum_apro_doct(), formexterinvi.getUsuario_crea(), 
    	formexterinvi.getFecha_crea(), formexterinvi.getUsuario_mod(), formexterinvi.getFecha_mod()));
      return _formexterinvi;
    }
   
}
