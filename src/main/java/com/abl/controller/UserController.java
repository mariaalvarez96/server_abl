package com.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abl.entity.User;
import com.abl.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/new")
	public ResponseEntity<String> createUser(String dni, String name, String email, int tlf, String pass) {
		//Comprueba si existe el dni
		if (usuarioRepository.existsById(dni)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this DNI already exists");
        } 
		
		User newUser = new User();
		newUser.setDni(dni);
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setTlf(tlf);
		newUser.setPassword(pass);

		// Guardar el nuevo usuario en la base de datos
		usuarioRepository.save(newUser);

		return ResponseEntity.ok("User created successfully");		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
		User existingUser = usuarioRepository.findByEmail(user.getEmail());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        // Usuario autenticado correctamente
        return ResponseEntity.ok().body(existingUser);
    }
}
