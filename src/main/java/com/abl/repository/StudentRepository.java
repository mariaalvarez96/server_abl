package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	@SuppressWarnings("unchecked")
	Student save(Student student);
}
