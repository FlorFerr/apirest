package com.flor.myapp.service;

import java.util.List;
import java.util.Optional;

import com.flor.myapp.entity.Lenguaje;

public interface ILenguajeService {

		public List<Lenguaje> findAll();
		
		public void saveLenguaje(Lenguaje lenguaje);
		
		public Optional<Lenguaje> findById(int id);
}
