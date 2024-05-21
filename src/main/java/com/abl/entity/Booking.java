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
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne()
	@JoinColumn(name = "id_user")
	User user;

	@ManyToOne()
	@JoinColumn(name = "student_id")
	Student student;

	@ManyToOne()
	@JoinColumn(name = "lesson_id")
	Lesson lesson;

	@Column(name = "time")
	String time;

	@Column(name = "date")
	String date;

	public Booking(String id, User user, Student student, Lesson lesson, String time, String date) {
		this.id = id;
		this.user = user;
		this.student = student;
		this.lesson = lesson;
		this.time = time;
		this.date = date;
	}

	public Booking() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
