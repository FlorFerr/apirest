package com.flor.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.myapp.entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {
	
	public List<Curso> findByProfesorId(int id);
	
	public void deleteByProfesorId(int id);
	
	public void deleteByIdAndProfesorId(int id, int profesorId);

}
