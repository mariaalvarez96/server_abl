package com.abl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.Booking;
import com.abl.entity.Lesson;
import com.abl.entity.User;
import com.abl.repository.LessonRepository;

@RestController
@RequestMapping("/lessons")
public class LessonController {

	@Autowired
	private LessonRepository lessonRepository;
	
	@GetMapping("/list")
	public ResponseEntity<Object> getLessons(){	
		List<Lesson> allLessons = lessonRepository.findAll();
		List<Lesson> getLessons = new ArrayList<>();
		for(Lesson lesson : allLessons) {
			getLessons.add(lesson);
		}
		return ResponseEntity.ok().body(getLessons);
	}
}
