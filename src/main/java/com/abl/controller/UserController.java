package com.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abl.entity.User;
import com.abl.repository.CustomerRepository;
import com.abl.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	private final PasswordEncoder passwordEncoder;

	public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/new")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		if (!customerRepository.existsById(user.getDni())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Debe ser cliente para poder registrarse.");
		}
		if (userRepository.existsById(user.getDni())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario con este DNI ya existe");
		}
		if (userRepository.findByEmail(user.getEmail()) != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("El usuario con este correo electrónico ya existe");
		}

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.save(user);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());

		if (existingUser == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El usuario con este correo no existe.");
		}
		if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta.");
		}
		return ResponseEntity.ok().body(existingUser);
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword(@RequestBody User user) {
		if (userRepository.existsById(user.getDni())) {
			User existingUser = userRepository.findById(user.getDni()).get();

			String encodedPassword = passwordEncoder.encode(user.getPassword());
			existingUser.setPassword(encodedPassword);

			User updatedUser = userRepository.save(existingUser);
			return ResponseEntity.ok().body(updatedUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/updateUserData")
	public ResponseEntity<Object> updateUserData(@RequestBody User user) {
		if (userRepository.existsById(user.getDni())) {

			User existingUser = userRepository.findById(user.getDni()).get();

			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPhone(user.getPhone());

			User updatedUser = userRepository.save(existingUser);
			return ResponseEntity.ok().body(updatedUser);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@PostMapping("/updateAvatar")
	public ResponseEntity<Object> uploadProfilePic(@RequestBody User user) {
		if (userRepository.existsById(user.getDni())) {
			User existingUser = userRepository.findById(user.getDni()).get();

			existingUser.setAvatar(user.getAvatar());

			User updatedUser = userRepository.save(existingUser);
			return ResponseEntity.ok().body(updatedUser);
		} else {
			return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("Imagen demasiado grande.");
		}

	}

	@DeleteMapping("/deleteAvatar/{id}")
	public ResponseEntity<Object> deleteProfilePic(@PathVariable String id) {
		if (userRepository.existsById(id)) {
			User existingUser = userRepository.findById(id).get();
			existingUser.setAvatar(null);
			User updatedUser = userRepository.save(existingUser);
			return ResponseEntity.ok().body(updatedUser);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe avatar para borrar.");
		}

	}
}
