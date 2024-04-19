package com.abl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	String nombreAlumno;
	
	@Column(name = "curso")
	String curso;
	
	@Column(name = "nombreUsuario")
	String nombreUsuario;
	
	public Student(String nombreAlumno, String curso, String nombreUsuario) {
		this.nombreAlumno = nombreAlumno;
		this.curso = curso;
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre_alumno() {
		return nombreAlumno;
	}

	public void setNombre_alumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombre_usuario() {
		return nombreUsuario;
	}

	public void setNombre_usuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public String toString() {
		return "alumno [nombreAlumno=" + nombreAlumno + ", curso=" + curso + ", nombreUsuario=" + nombreUsuario
				+ "]";
	}
	
	
}
