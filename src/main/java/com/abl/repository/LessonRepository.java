package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String>{

	@SuppressWarnings("unchecked")
	Lesson save(Lesson lesson);
	Lesson findById(Lesson lesson);
	
}
