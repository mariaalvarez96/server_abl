package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.Booking;
import com.abl.entity.Lesson;
import com.abl.entity.Student;
import com.abl.entity.User;

public interface BookingRepository extends JpaRepository<Booking, String>{

	@SuppressWarnings("unchecked")
	Booking save(Booking booking);
	Booking findById(Booking booking);
	boolean existsByUserAndStudentAndLessonAndTimeAndDate(
            User user, Student student, Lesson lesson, String time, String date);
}
