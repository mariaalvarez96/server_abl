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
import com.abl.entity.User;
import com.abl.repository.BookingRepository;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/new")
	public ResponseEntity<Object> createUser(@RequestBody Booking booking) {
		if (bookingRepository.existsById(booking.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esta reserva ya existe.");
        }
		bookingRepository.save(booking);
		return ResponseEntity.ok().body(booking);		
	}
}
