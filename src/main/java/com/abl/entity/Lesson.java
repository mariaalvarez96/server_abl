
package com.abl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	String id;

	@Column(name = "name")
	String name;

	@Column(name="day")
	String day;
	
	@Column(name="time")
	String time;

	public Lesson() {}

	public Lesson(String id, String name, String day, String time) {
		super();
		this.id = id;
		this.name = name;
		this.day = day;
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
