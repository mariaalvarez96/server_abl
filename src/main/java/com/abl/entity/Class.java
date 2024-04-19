package com.abl.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class Class {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	String id;
	
	@Column(name = "nombre")
	String nombre;
	
	@Column(name = "date")
	Date diaHora;
	
	public Class(String id, String nombre, Date diaHora) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.diaHora = diaHora;
	}

	public String getId_clase() {
		return id;
	}

	public void setId_clase(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDia_hora() {
		return diaHora;
	}

	public void setDia_hora(Date diaHora) {
		this.diaHora = diaHora;
	}
	
	
}
