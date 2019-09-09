package com.espe.crud.controllers;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espe.crud.model.solicitudes;
import com.espe.crud.repository.solicitudesRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class solicitudesController {

	  @Autowired
	  private solicitudesRepository repository;
	  
	  
	  @GetMapping("/solicitud")
	  public List<solicitudes> getAllSolicitudes() {
	       System.out.println("Get all Solicitudes");
	       
	       List<solicitudes> solicitudes = new ArrayList<>();
	       repository.findAll().forEach(solicitudes::add);
	       return solicitudes;
	    }
	      
	    @RequestMapping(value = "/consumir/{id}", method = RequestMethod.GET)
		  public ResponseEntity<?> getRequestInformation(@PathVariable Long id)
				throws SQLException {
			// To receive the response
			StringBuilder content = new StringBuilder();
			// Construct manually a JSON object in Java, for testing purposes an object with
			 JSONObject json = new JSONObject();
			try {

		


				// information passed
				String webService = "https://aplicaciones.espe.edu.ec:8443/authentication/api/query/ced="+id+"&auth=ba82e1071cd1ea9669a62f24213ba4a4.cf3df0e97b7a4cc68aeaab8d6bbb9691?fbclid=IwAR3D3xBT2UZEsNo04ZeKSW4CIdYtB1tVdC0X5QXRxWCDIlXBw2WxXLGkymc";
	            URL url = new URL(webService);
				HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
				httpConnection.setDoOutput(true);
				httpConnection.setRequestMethod("GET");
				httpConnection.setRequestProperty("Content-Type", "application/json");
				httpConnection.setRequestProperty("Accept", "application/json");

				// Writes the JSON parsed as string to the connection
				Integer responseCode = httpConnection.getResponseCode();

				BufferedReader bufferedReader;

				// Creates a reader buffer
				if (responseCode > 199 && responseCode < 300) {
					bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
				} else {
					bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
				}

				String line;
				while ((line = bufferedReader.readLine()) != null) {
					content.append(line).append("\n");
				}
				bufferedReader.close();

				// Prints the response
				System.out.println(json);

			} catch (Exception e) {
				System.out.println("Error Message");
				System.out.println(e.getClass().getSimpleName());
				System.out.println(e.getMessage());
			}
			return new ResponseEntity<>(content, HttpStatus.OK);
		}
	  
		  @GetMapping(value="/solicitud/{id}")
		  public List<solicitudes> findById(@PathVariable int id) {
		       System.out.println("Get all Solicitudes");
		       
		       List<solicitudes> solicitudes = repository.findById(id);
		       return solicitudes;
		    }
	    
		//**CREA UNA  NUEVA SOLICITUD**
		    
		    @PostMapping(value = "/solicitud")
		    public solicitudes postSolicitudes(@RequestBody solicitudes solicitudes) {
		    	solicitudes _solicitudes = repository.save(new solicitudes(solicitudes.getId_convo(), solicitudes.getNombre(), 
		    			    solicitudes.getUsuario_crea(), solicitudes.getFecha_crea(), solicitudes.getUsuario_mod(), solicitudes.getFecha_mod()));
		      return _solicitudes;
		    }
		    
		  
		    //**EDITA UNA SOLICITUD DE ACUERDO A SU ID**
		    
		    @PutMapping("/solicitud/{id}")
		    public ResponseEntity<solicitudes> updateSolicitudes(@PathVariable("id") 
		    Long id, @RequestBody solicitudes solicitudes) {
		      System.out.println("Update solicitudes with ID = " + id + "...");
		      Optional<solicitudes> solicitudesData = repository.findById(id);
		   
		      if (solicitudesData.isPresent()) {
		    	  solicitudes _solicitudes = solicitudesData.get();
		    	  _solicitudes.setId_convo(solicitudes.getId_convo());
		    	  _solicitudes.setNombre(solicitudes.getNombre());	
		    	  _solicitudes.setUsuario_crea(solicitudes.getUsuario_crea());
		    	  _solicitudes.setFecha_crea(solicitudes.getFecha_crea());
		    	  _solicitudes.setUsuario_mod(solicitudes.getUsuario_mod());
		    	  _solicitudes.setFecha_mod(solicitudes.getFecha_mod());
		    	  

		        return new ResponseEntity<>(repository.save(_solicitudes), HttpStatus.OK);
		      } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		      }
		    }

}
