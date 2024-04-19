package com.abl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
    @Column(name = "dni")
	String dni;
	
	@Column(name = "name")
	String nombre;
	
	@Column(name = "phone_number")
	int tlf;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;
	
	public User(String dni, String nombre, int tlf, String email, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.tlf = tlf;
		this.email = email;
		this.password = password;
	}

	public User() {}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
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
	
	
}
