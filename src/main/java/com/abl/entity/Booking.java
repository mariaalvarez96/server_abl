package com.abl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {

	@Id
    @Column(name = "id")
	String id;
	
	@Column(name = "id_user")
	String userId;

	@Column(name = "student_name")
	String studentName;

	@ManyToOne()
    @JoinColumn(name = "lesson_id")
	Lesson lesson;

	public Booking(String id, String userId, String student_name) {
		this.id = id;
		this.userId = userId;
		this.studentName = student_name;
	}
	
	public Booking() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

}
