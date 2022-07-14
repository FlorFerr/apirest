package com.flor.myapp.service;

import java.util.List;

import com.flor.myapp.entity.Curso;

public interface ICursoService {
	
	public List<Curso> findAll();
	
	public List<Curso> findByProfesorId(int id);
	
	public Curso save(Curso curso);
	
	public void deleteByProfesorId(int id);
	
	public void deleteAll();
	
	public void deleteCursoById(int id, int profesorId);

	
}
