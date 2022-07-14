package com.flor.myapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flor.myapp.entity.Lenguaje;

public interface ILenguajeRepository extends JpaRepository<Lenguaje, Integer> {
	
	public Optional<Lenguaje> findById(int id);

}
