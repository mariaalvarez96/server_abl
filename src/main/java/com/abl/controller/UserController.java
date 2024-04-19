package com.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.User;
import com.abl.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/new")
	public ResponseEntity<String> createUser() {
		User newUser = new User();
		newUser.setDni("12345678A");
		newUser.setNombre("Juan");
		newUser.setEmail("juan@example.com");
		newUser.setTlf(Integer.parseInt("123456789"));
		newUser.setPassword("password");

		usuarioRepository.save(newUser);

		return ResponseEntity.ok("User created successfully");
	}

	@GetMapping("/{id}")
	public String getUserById(@PathVariable String id) {
		return "Obtaining user by id: " + id;
	}
}
