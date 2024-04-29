package com.abl.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {

	@Id
    @Column(name = "id_booking")
	String id_booking;
	
	@Column(name = "id_user")
	String userId;
	
	@Column(name = "id_class")
	String id_class;
	
	@Column(name = "student_name")
	String student_name;
	
	public Booking(String id_booking, String userId, String id_class, String student_name) {
		this.id_booking = id_booking;
		this.userId = userId;
		this.id_class = id_class;
		this.student_name = student_name;
	}
	
	public Booking() {}

	public String getId() {
		return id_booking;
	}

	public void setId(String id_booking) {
		this.id_booking = id_booking;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdclass() {
		return id_class;
	}

	public void setIdclass(String id_class) {
		this.id_class = id_class;
	}

	public String getStudentName() {
		return student_name;
	}

	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}

	@Override
	public String toString() {
		return "reserva [id_booking=" + id_booking + ", nombreUsuario=" + userId + ", nombreClase=" + id_class
				+ ", student_name=" + student_name + "]";
	}
		
}
