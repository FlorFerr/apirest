package com.flor.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flor.myapp.entity.Curso;
import com.flor.myapp.entity.Profesor;
import com.flor.myapp.service.CursoService;
import com.flor.myapp.service.ProfesorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfesorService profesorService;
	
	@GetMapping("/cursos")
	public ResponseEntity<?> getAll(){
		List<Curso> cursos = cursoService.findAll();
		
		if(cursos.isEmpty()) {
			return new ResponseEntity<>("No se encontraron cursos", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
	}
	
	@GetMapping("/cursos/{id}")
	public ResponseEntity<?> getCursoByProf(@PathVariable int id){
		
		List<Curso> cursos = cursoService.findByProfesorId(id);
		
		if(cursos.isEmpty()) {
			return new ResponseEntity<>("No se encontraron cursos para el usuario indicado", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(cursos, HttpStatus.OK);
		}
		
	}
	@PostMapping("/cursos")
	public ResponseEntity<?> saveCurso(@RequestBody Curso curso){
		int profesorId = curso.getProfesorId();
		
		Profesor profesor = profesorService.findByIdSql(profesorId);
		
		if(profesor != null) {
			cursoService.save(curso);
			return new ResponseEntity<>(curso, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Id no encontrado", HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/cursos/{id}")
	public ResponseEntity<String> deleteByProfesorId(@PathVariable int id){
		List<Curso> cursos = cursoService.findByProfesorId(id);
		
		if(cursos.isEmpty()) {
			return new ResponseEntity<>("No se encontraron cursos para el usuario indicado", HttpStatus.NOT_FOUND);
		}else {
			cursoService.deleteByProfesorId(id);
			return new ResponseEntity<>("Cursos eliminados", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/cursos/delete")
	public ResponseEntity<String> deleteAll(){
		List<Curso> cursos = cursoService.findAll();
		
		if(cursos.isEmpty()) {
			return new ResponseEntity<>("No se encontraron cursos", HttpStatus.NOT_FOUND);
		}else {
			cursoService.deleteAll();
			return new ResponseEntity<>("Cursos eliminados", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/cursos/{profesorId}/{id}")
	public ResponseEntity<String> deleteCursoById(@PathVariable int profesorId, @PathVariable int id){
		
		List<Curso> cursos = cursoService.findByProfesorId(profesorId);
		
		if(cursos.isEmpty()) {
			return new ResponseEntity<>("No se encontraron cursos", HttpStatus.NOT_FOUND);
		}else {
			cursoService.deleteCursoById(id, profesorId);
			return new ResponseEntity<>("Curso eliminado", HttpStatus.OK);
		}
		
	}

}
