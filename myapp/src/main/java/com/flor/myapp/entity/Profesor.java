package com.flor.myapp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Teachers")
public class Profesor implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String lastName;
	
	@Column(length = 60, unique =true)
	private String email;
	
	private String password;
	
	private String photo;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="profesorId", referencedColumnName="id")
	private List<Curso> cursos = new ArrayList<>();
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="profesores_lenguajes", joinColumns = @JoinColumn(name="profesor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="lenguaje_id", referencedColumnName="id"))
	private Set<Lenguaje> lenguajes = new HashSet<>();
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public Profesor() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<Lenguaje> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(Set<Lenguaje> lenguajes) {
		this.lenguajes = lenguajes;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", photo=" + photo + ", createAt=" + createAt + "]";
	}
	
	private static final long serialVersionUID = 1L;
	
}
