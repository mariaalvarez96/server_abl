package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, String>{

	@SuppressWarnings("unchecked")
	Booking save(Booking booking);
	Booking findById(Booking booking);
}
