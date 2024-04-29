package com.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.Booking;
import com.abl.repository.BookingRepository;

@RestController
@RequestMapping("/classes")
public class ClassController {

	@Autowired
	private ClassRepository classRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/list")
	public ResponseEntity<Object> list(@RequestBody Booking booking) {
		return ResponseEntity.ok().body(classRepository);		
	}
}
