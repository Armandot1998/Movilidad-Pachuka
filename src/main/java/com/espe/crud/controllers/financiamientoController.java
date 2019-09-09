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

import com.espe.crud.model.financiamiento;
import com.espe.crud.repository.financiamientoRepository;

@CrossOrigin(origins = "*")
@RestController
public class financiamientoController {


    public static final Logger logger = LoggerFactory.getLogger(financiamientoController.class);


    @Autowired
    financiamientoRepository repository;
    
    //**MUÃ‰STRA TODOS LOS FIINANCIAMIENTOS EXISTENTES EN LA BASE DE DADTOS**
    
    @GetMapping("/fininanciamiento")
    public List<financiamiento> getAllExternons() {
      System.out.println("Get all Financiamientos ...");
   
      List<financiamiento> financiamiento = new ArrayList<>();
      repository.findAll().forEach(financiamiento::add);
   
      return financiamiento;
    }
    
    //**MUÃ‰STRA UN FINANCIAMIENTO ESPECÃ�FICO 
    
    @GetMapping(value = "financiamiento/{id}")
    public List<financiamiento> findById(@PathVariable int id) {
   
      List<financiamiento> financiamiento = repository.findById(id);
      return financiamiento;
    }

    //**CREA UN NUEVO D.EXTERNO**
    
    @PostMapping(value = "/financiamiento")
    public financiamiento postFinanciamiento(@RequestBody financiamiento financiamiento) {
      financiamiento _financiamiento = repository.save(new financiamiento( financiamiento.getId_gestinv(),
      financiamiento.getId_fmovilidad(), financiamiento.getId_testint(), financiamiento.getId_externo(), financiamiento.getId_pasaje(), 
      financiamiento.getFinan_viatico(), financiamiento.getOtros(), financiamiento.getTotal(), financiamiento.getUsuario_crea(), 
      financiamiento.getFecha_crea(), financiamiento.getUsuario_mod(), financiamiento.getFecha_mod()));
      return _financiamiento;
    }
    
    //**EDITA UN FINANCIAMIENTO DE ACUERDO A SU ID**
    
    @PutMapping("/financiamiento/{id}")
    public ResponseEntity<financiamiento> updateFinanciamiento(@PathVariable("id") 
    Long id, @RequestBody financiamiento financiamiento) {
      System.out.println("Update financiamiento with ID = " + id + "...");
      Optional<financiamiento> financiamientoData = repository.findById(id);
   
      if (financiamientoData.isPresent()) {
    	  financiamiento _financiamiento = financiamientoData.get();
        _financiamiento.setId_gestinv(financiamiento.getId_gestinv());
        _financiamiento.setId_fmovilidad(financiamiento.getId_fmovilidad());
        _financiamiento.setId_testint(financiamiento.getId_testint());
        _financiamiento.setId_externo(financiamiento.getId_externo());
        _financiamiento.setId_pasaje(_financiamiento.getId_pasaje());
        _financiamiento.setFinan_viatico(financiamiento.getFinan_viatico());
        _financiamiento.setOtros(financiamiento.getOtros());
        _financiamiento.setTotal(financiamiento.getOtros());
        _financiamiento.setUsuario_crea(financiamiento.getUsuario_crea());
        _financiamiento.setFecha_crea(financiamiento.getFecha_crea());
        _financiamiento.setUsuario_mod(financiamiento.getUsuario_mod());
        _financiamiento.setFecha_mod(financiamiento.getFecha_mod());
       
        

        return new ResponseEntity<>(repository.save(_financiamiento), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
