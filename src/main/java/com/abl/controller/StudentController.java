package com.abl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.Booking;
import com.abl.entity.Student;
import com.abl.entity.User;
import com.abl.repository.StudentRepository;
import com.abl.repository.UserRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/new")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		if (studentRepository.existsById(student.getDni())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already exists");
		}
		studentRepository.save(student);
		return ResponseEntity.ok().body(student);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getStudentsByUser(@PathVariable String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			List<Student> allStudents = studentRepository.findAll();
			List<Student> userStudents = new ArrayList<>();
			for (Student student : allStudents) {
				if (student.getUser().getDni().equals(userId)) {
					userStudents.add(student);
				}
			}
			return ResponseEntity.ok().body(userStudents);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
