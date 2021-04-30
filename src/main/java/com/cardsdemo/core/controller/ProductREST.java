package com.cardsdemo.core.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsdemo.core.conectors.ConectorWS;
import com.jaimeMW.springsoap.client.gen.GetCountryResponse;

@RestController //si queremos que nos devuelva una template html Paginas.LOGIN, tiene que ser Controller, NO REST
@RequestMapping("/countries")
public class ProductREST {
	
	@Autowired
	private ConectorWS conectorWS;
	
	
	@GetMapping(path="/{name}")
	public ResponseEntity<GetCountryResponse> getProductById(@PathVariable("name") String name){
		//si quisieramos poner un transformer de datos de entrada, iria aqui
		GetCountryResponse response=conectorWS.getCountry(name); //y aqui le pasamos el input (en este caso solo un name)
		//si quisieramos poner un transformer de datos de salida, iria aqui
		if(response!=null) { //si hay una respuesta
			return ResponseEntity.ok(response); //pues alla va
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
}
