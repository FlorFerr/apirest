package com.flor.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flor.myapp.dao.ILenguajeRepository;
import com.flor.myapp.entity.Lenguaje;

@Service
public class LenguajeService implements ILenguajeService {
	
	@Autowired
	private ILenguajeRepository lenguajeRepository;

	@Override
	@Transactional
	public List<Lenguaje> findAll() {
		return lenguajeRepository.findAll();
	}

	@Override
	@Transactional
	public void saveLenguaje(Lenguaje lenguaje) {
		lenguajeRepository.save(lenguaje);
	}

	@Override
	@Transactional
	public Optional<Lenguaje> findById(int id) {
		return lenguajeRepository.findById(id);
	}
	

}
