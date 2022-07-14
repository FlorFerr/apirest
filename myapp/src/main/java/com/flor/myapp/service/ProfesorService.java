package com.flor.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.myapp.dao.IProfesorRepository;
import com.flor.myapp.entity.Profesor;

@Service
public class ProfesorService implements IProfesorService{

	
	@Autowired
	private IProfesorRepository profesorRepository;

	@Override
	@Transactional
	public void saveProfesor(Profesor profesor) {
		profesorRepository.save(profesor);		
	}

	@Override
	@Transactional
	public List<Profesor> findAll() {
		return profesorRepository.findAll();
	}

	@Override
	@Transactional
	public Profesor findProfesor(Profesor profesor) {
		return profesorRepository.findByEmail(profesor.getEmail());
	}

	@Override
	@Transactional
	public Profesor checkProfesorLogin(Profesor profesor) {
		return profesorRepository.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
	}

	@Override
	@Transactional
	public Profesor findByIdSql(int id) {
		return profesorRepository.findByIdSql(id);
	}

	@Override
	@Transactional
	public void deleteProfesor(int id) {
		profesorRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateProfesor(Profesor profesor) {
		profesorRepository.save(profesor);
	}

	@Override
	@Transactional
	public void deleteAll() {
		profesorRepository.deleteAll();
	}

	



}
