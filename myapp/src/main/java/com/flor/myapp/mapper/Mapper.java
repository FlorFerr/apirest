package com.flor.myapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.flor.myapp.entity.Profesor;
import com.flor.myapp.model.MProfesor;

@Component("mapper")
public class Mapper {

	public static MProfesor mapProfesor(Profesor profesor) {
		return new MProfesor(profesor);
	}
	
	public static List<MProfesor> mapProfesores(List<Profesor> profesores){
		List<MProfesor> mProfesores = new ArrayList<>();
		for(Profesor profesor:profesores) {
			mProfesores.add(new MProfesor(profesor));
		}
		return mProfesores;
	}
	

}
