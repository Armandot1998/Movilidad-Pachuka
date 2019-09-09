package com.espe.crud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.espe.crud.model.tipoconve;
import com.espe.crud.repository.tipoconveRepository;






@CrossOrigin(origins = "*")
@RestController

public class tipoconveController {


    @Autowired
    tipoconveRepository repository;
    
    //**MUETRA TODAS LOS TIPCONVE EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/tipoconv")
    public List<tipoconve> getAllCongresos() {
      System.out.println("Get all Tipoconves ...");
   
      List<tipoconve> tipoconve = new ArrayList<>();
      repository.findAll().forEach(tipoconve::add);
   
      return tipoconve;
    }
    
    //**MUESTRA UN TIPCONVEESPECÃ�FICO
    
    @GetMapping(value = "/tipoconve/{id}")
    public List<tipoconve> findById(@PathVariable int id) {
   
      List<tipoconve> tipoconve = repository.findById(id);
      return tipoconve;
    }

    //**CREA UN NUEVO TIPCONVE**
    
    @PostMapping(value = "/tipoconve")
    public tipoconve postTipoconve(@RequestBody tipoconve tipoconve) {
    	tipoconve _tipoconve = repository.save(new tipoconve( 
    			
    			tipoconve.getNombre(),
    			tipoconve.getUsuario_crea(),
    			tipoconve.getFecha_crea(),
    			tipoconve.getUsuario_mod(),
    			tipoconve.getFecha_mod()));
      return _tipoconve;
    }
    
    //**EDITA UN TIPCONVE DE ACUERDO A SU ID**
    
    @PutMapping("/tipoconve/{id}")
    public ResponseEntity<tipoconve> updateTipoconve(@PathVariable("id") 
    Long id, @RequestBody tipoconve tipoconve) {
      System.out.println("Update tipoconve with ID = " + id + "...");
      Optional<tipoconve> tipoconveData = repository.findById(id);
   
      if (tipoconveData.isPresent()) {
    	  tipoconve _tipoconve = tipoconveData.get();
        
        _tipoconve.setNombre(tipoconve.getNombre());
        _tipoconve.setUsuario_crea(tipoconve.getUsuario_crea());
        _tipoconve.setFecha_crea(tipoconve.getFecha_crea());
        _tipoconve.setUsuario_mod(tipoconve.getUsuario_mod());
        _tipoconve.setFecha_mod(tipoconve.getFecha_mod());
        
        return new ResponseEntity<>(repository.save(_tipoconve), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
	    
}
