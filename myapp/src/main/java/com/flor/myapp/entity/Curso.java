package com.flor.myapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
public class Curso implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int profesorId;
	
	public Curso() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", name=" + name + ", profesorId=" + profesorId + "]";
	}

	private static final long serialVersionUID = 1L;
	
}
