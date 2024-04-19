package com.abl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "reservations")
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	String id;
	
	@Column(name = "nombreUsuario")
	String nombreUsuario;
	
	@Column(name = "nombreClase")
	String nombreClase;
	
	@Column(name = "nombreAlumno")
	String nombreAlumno;
	
	public Booking(String id, String nombreUsuario, String nombreClase, String nombre_alumno) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.nombreClase = nombreClase;
		this.nombreAlumno = nombre_alumno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre_usuario() {
		return nombreUsuario;
	}

	public void setNombre_usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre_clase() {
		return nombreClase;
	}

	public void setNombre_clase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public String getNombre_alumno() {
		return nombreAlumno;
	}

	public void setNombre_alumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	@Override
	public String toString() {
		return "reserva [id=" + id + ", nombreUsuario=" + nombreUsuario + ", nombreClase=" + nombreClase
				+ ", nombreAlumno=" + nombreAlumno + "]";
	}
		
}
