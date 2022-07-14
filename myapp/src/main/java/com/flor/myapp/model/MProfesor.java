package com.flor.myapp.model;

import com.flor.myapp.entity.Profesor;

public class MProfesor {
	
	private int id;
	private String name;
	private String lastName;
	private String photo;
	
	public MProfesor () {}
	
	public MProfesor(Profesor profesor) {
		this.id = profesor.getId();
		this.name = profesor.getName();
		this.lastName = profesor.getLastName();
		this.photo = profesor.getPhoto();
	}
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
