package com.flor.myapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="lenguajes")
public class Lenguaje implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Date date;
	
	@ManyToMany
	@JoinTable(name="profesores_lenguajes", joinColumns = @JoinColumn(name="lenguaje_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="profesor_id", referencedColumnName="id"))
	private Set<Profesor> profesores = new HashSet<>();
	
	public Lenguaje() {}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Lenguaje [id=" + id + ", name=" + name + ", date=" + date + ", profesores=" + profesores + "]";
	}
	
	private static final long serialVersionUID = 1L;
}
