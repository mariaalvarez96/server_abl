package com.abl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		if (usuarioRepository.existsById(user.getDni())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User with this DNI already exists");
        }
		usuarioRepository.save(user);
		return ResponseEntity.ok().body(user);		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody User user) {
		User existingUser = usuarioRepository.findByEmail(user.getEmail());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok().body(existingUser);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updatePassword")
	public ResponseEntity<Object> updatePassword(@RequestBody User user){
		if (usuarioRepository.existsById(user.getDni())) {
	        User existingUser = usuarioRepository.findById(user.getDni()).get();
	        existingUser.setPassword(user.getPassword());
	        User updatedUser = usuarioRepository.save(existingUser);
	        return ResponseEntity.ok().body(updatedUser); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateUserData")
	public ResponseEntity<Object> updateUserData(@RequestBody User user){
		if (usuarioRepository.existsById(user.getDni())) {
			
	        User existingUser = usuarioRepository.findById(user.getDni()).get();

	        existingUser.setName(user.getName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPhone(user.getPhone());
	        
	        User updatedUser = usuarioRepository.save(existingUser);
	        return ResponseEntity.ok().body(updatedUser); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
	}
}
