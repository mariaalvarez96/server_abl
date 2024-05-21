package com.abl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	@SuppressWarnings("unchecked")
	User save(User user);

	User findByEmail(String email);
}
