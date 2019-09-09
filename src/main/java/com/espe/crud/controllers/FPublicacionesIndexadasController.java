package com.espe.crud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.espe.crud.model.FPublicacionesIndexadas;
import com.espe.crud.repository.FPublicacionesIndexadasRepository;

@CrossOrigin(origins = "*")
@RestController
public class FPublicacionesIndexadasController {

    public static final Logger logger = LoggerFactory.getLogger(FPublicacionesIndexadasController.class);


    @Autowired
    FPublicacionesIndexadasRepository repository;
    //**CREA UNA NUEVO D.EXTERNO**
    
    @PostMapping(value = "/FPublicacionesIndexada")
    public FPublicacionesIndexadas postFPublicacionesIndexadas(@RequestBody FPublicacionesIndexadas FPublicacionesIndexadas) {
    	FPublicacionesIndexadas _FPublicacionesIndexadas = repository.save(new FPublicacionesIndexadas(
    	FPublicacionesIndexadas.getId_congresxp(), FPublicacionesIndexadas.getId_solicitmov(), 
    	FPublicacionesIndexadas.getId_movbd(), FPublicacionesIndexadas.getNom_artic(), FPublicacionesIndexadas.getNom_revis(),
    	FPublicacionesIndexadas.getUsuario_crea(), FPublicacionesIndexadas.getFecha_crea(), FPublicacionesIndexadas.getUsuario_mod(), 
    	FPublicacionesIndexadas.getFecha_mod()));
      return _FPublicacionesIndexadas;
    }
   
}
