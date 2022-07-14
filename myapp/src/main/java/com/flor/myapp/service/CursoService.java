package com.flor.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.myapp.dao.ICursoRepository;
import com.flor.myapp.entity.Curso;

@Service
public class CursoService implements ICursoService {
	
	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	@Transactional
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	@Transactional
	public List<Curso> findByProfesorId(int id) {
		return cursoRepository.findByProfesorId(id);
	}

	@Override
	@Transactional
	public Curso save(Curso curso) {
		cursoRepository.save(curso);
		return curso;
	}

	@Override
	@Transactional
	public void deleteByProfesorId(int id) {
		cursoRepository.deleteByProfesorId(id);
	}

	@Override
	@Transactional
	public void deleteAll() {
		cursoRepository.deleteAll();
	}

	@Override
	@Transactional
	public void deleteCursoById(int id, int profesorId) {
		cursoRepository.deleteByIdAndProfesorId(id, profesorId);
	}

}
