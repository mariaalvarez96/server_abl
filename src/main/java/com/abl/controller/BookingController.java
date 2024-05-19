package com.abl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.Booking;
import com.abl.entity.User;
import com.abl.repository.BookingRepository;
import com.abl.repository.UserRepository;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getBookingsByUser(@PathVariable String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			List<Booking> allBookings = bookingRepository.findAll();
			List<Booking> userBookings = new ArrayList<>();
			for (Booking booking : allBookings) {
				if (booking.getUser().getDni().equals(userId)) {
					userBookings.add(booking);
				}
			}
			return ResponseEntity.ok().body(userBookings);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/new")
	public ResponseEntity<Object> createBooking(@RequestBody Booking booking) {
		if (bookingRepository.existsByUserAndStudentAndLessonAndTimeAndDate(booking.getUser(), booking.getStudent(),
				booking.getLesson(), booking.getTime(), booking.getDate())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Esta reserva ya existe.");
		}
		bookingRepository.save(booking);
		return ResponseEntity.ok().body(booking);
	}

	@DeleteMapping("/{idBooking}")
	public ResponseEntity<Object> deleteBooking(@PathVariable String idBooking) {
		if (bookingRepository.existsById(idBooking)) {
			bookingRepository.deleteById(idBooking);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
