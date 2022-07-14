package com.flor.myapp.service;

import java.util.List;

import com.flor.myapp.entity.Profesor;

public interface IProfesorService {
	
	public void saveProfesor(Profesor profesor);
	
	public List<Profesor> findAll();
	
	public Profesor findProfesor(Profesor profesor);
	
	public Profesor checkProfesorLogin(Profesor profesor);
	
	public Profesor findByIdSql(int id);
	
	public void deleteProfesor(int id);
	
	public void updateProfesor(Profesor profesor);
	
	public void deleteAll();
}
