package com.abl.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.abl.entity.User;

public interface UsuarioRepository extends JpaRepository<User, String> {
	
	User save(User user);
}
