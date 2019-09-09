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

import com.espe.crud.model.externo;
import com.espe.crud.repository.externoRepository;





@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController

public class externoController {


	    public static final Logger logger = LoggerFactory.getLogger(externoController.class);


	    @Autowired
	    externoRepository repository;
	    
	    //**MUÃ‰STRA TODAS LOS D.EXTERNOS EXISTENTES EN LA BASE DE DADTOS**
	    
	    @GetMapping("/externo")
	    public List<externo> getAllExternons() {
	      System.out.println("Get all Externos ...");
	   
	      List<externo> externo = new ArrayList<>();
	      repository.findAll().forEach(externo::add);
	   
	      return externo;
	    }
	    
	    //**MUÃ‰STRA UN D.EXTERNO ESPECÃ�FICO 
	    
	    @GetMapping(value = "externo/{id}")
	    public List<externo> findById(@PathVariable int id) {
	   
	      List<externo> externo = repository.findById(id);
	      return externo;
	    }

	    //**CREA UNA NUEVO D.EXTERNO**
	    
	    @PostMapping(value = "/externo")
	    public externo postExterno(@RequestBody externo externo) {
	      externo _externo = repository.save(new externo(externo.getId_convenio(), externo.getDocentexter(), 
	      externo.getSolicitmov(), externo.getGrup_inv(), externo.getLinea_inv(), externo.getBenef(), externo.getFech_inic(), 
	      externo.getFech_fin(), externo.getObj(), externo.getMetodo(), externo.getMeta(), externo.getEntreg(), 
	      externo.getCode(), externo.getPdm(), externo.getUsuario_crea(), externo.getFecha_crea(),
	      externo.getUsuario_mod(), externo.getFecha_mod()));
	      return _externo;
	    }
	    
	    //**EDITA UN D.EXTERNO DE ACUERDO A SU ID**
	    
	    @PutMapping("/externo/{id}")
	    public ResponseEntity<externo> updateExterno(@PathVariable("id") 
	    Long id, @RequestBody externo externo) {
	      System.out.println("Update d.externo with ID = " + id + "...");
	      Optional<externo> externoData = repository.findById(id);
	   
	      if (externoData.isPresent()) {
	        externo _externo = externoData.get();
	        _externo.setId_convenio(externo.getId_convenio());
	        _externo.setDocentexter(externo.getDocentexter());
	        _externo.setSolicitmov(externo.getSolicitmov());
	        _externo.setGrup_inv(externo.getGrup_inv());
	        _externo.setLinea_inv(externo.getLinea_inv());
	        _externo.setBenef(externo.getBenef());
	        _externo.setFech_inic(externo.getFech_inic());
	        _externo.setFech_fin(externo.getFech_fin());
	        _externo.setObj(externo.getObj());
	        _externo.setMetodo(externo.getMetodo());
	        _externo.setMeta(externo.getMeta());
	        _externo.setEntreg(externo.getEntreg());
	        _externo.setCode(externo.getCode());
	        _externo.setPdm(externo.getPdm());
	        _externo.setUsuario_crea(externo.getUsuario_crea());
	        _externo.setFecha_crea(externo.getFecha_crea());
	        _externo.setUsuario_mod(externo.getUsuario_mod());
	        _externo.setFecha_mod(externo.getFecha_mod());
	        

	        return new ResponseEntity<>(repository.save(_externo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }

}
