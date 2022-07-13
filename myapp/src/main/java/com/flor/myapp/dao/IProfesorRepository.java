package com.flor.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flor.myapp.entity.Profesor;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {
	
	public Profesor findByEmail(String email);
	
	public Profesor findByEmailAndPassword(String email, String password);
	
	@Query("Select p from Profesor p where p.id=?1")
	public Profesor findByIdSql(int id);


	

}
