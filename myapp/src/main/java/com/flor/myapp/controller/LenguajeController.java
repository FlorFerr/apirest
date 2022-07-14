package com.flor.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.myapp.entity.Lenguaje;
import com.flor.myapp.service.LenguajeService;
import com.flor.myapp.service.ProfesorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LenguajeController {
	
	@Autowired
	private LenguajeService lenguajeService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/lenguajes")
	public ResponseEntity<?> getAll(){
		
		List<Lenguaje> lenguajes = lenguajeService.findAll();
		
		if(lenguajes.isEmpty()) {
			return new ResponseEntity<>("No se encontraton lenguajes", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(lenguajes, HttpStatus.OK);
		}
	}
	
	@PostMapping("/lenguajes")
	public ResponseEntity<?> saveLenguaje(Lenguaje lenguaje){
		
	
		return null;
		
	}

}
