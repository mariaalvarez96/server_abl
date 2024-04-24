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
	String name;
	
	@Column(name = "phone_number")
	int phone;
	
	@Column(name = "email", unique=true)
	String email;
	
	@Column(name = "password")
	private String password;
	
	public User(String dni, String name, int phone, String email, String password) {
		this.dni = dni;
		this.name = name;
		this.phone = phone;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
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
