package com.flor.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.myapp.entity.Profesor;
import com.flor.myapp.service.ProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/profesores")
	public List<Profesor> getAll(){
		return profesorService.findAll();
	}
	
	@PostMapping("/profesores")
	public ResponseEntity<?> saveProf(@RequestBody Profesor profesor) {
		if(profesorService.findProfesor(profesor) == null) {
			profesorService.saveProfesor(profesor);
			return new ResponseEntity<>(profesor, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("El usuario ya existe", HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/profesores/{id}")
	public ResponseEntity<?> updateProf(@PathVariable int id, @RequestBody Profesor profesor) {
		
		Profesor theProfesor = profesorService.findByIdSql(id);
		
		if(theProfesor != null) {
			theProfesor.setName(profesor.getName());
			theProfesor.setLastName(profesor.getLastName());
			theProfesor.setEmail(profesor.getEmail());
			
			profesorService.updateProfesor(theProfesor);
			return new ResponseEntity<>(profesor, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/profesores/{id}")
	public ResponseEntity<?> deleteProfesor(@PathVariable int id){
		
		Profesor theProfesor = profesorService.findByIdSql(id);
		
		if(theProfesor != null) {
			profesorService.deleteProfesor(id);
			return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/profesores/delete")
	public ResponseEntity<?> deleteAll(){
		
		List<Profesor> profesores = profesorService.findAll();
		
		if(profesores.isEmpty()) {
			
				return new ResponseEntity<>("No se encontraron usuarios", HttpStatus.NOT_FOUND);
			
		}else {
			profesorService.deleteAll();
			return new ResponseEntity<>("Usuarios eliminados", HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor) {
			Profesor theProfesor = profesorService.checkProfesorLogin(profesor);
			if(theProfesor != null) {
				return new ResponseEntity<>("Ok", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Usuario o contraseña incorrectas", HttpStatus.CONFLICT);
			}	
	}
	

}
