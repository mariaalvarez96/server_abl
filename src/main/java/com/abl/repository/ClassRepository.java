package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Lesson;

public interface ClassRepository extends JpaRepository<Lesson, String>{

	@SuppressWarnings("unchecked")
	Lesson save(Lesson clas);
}
