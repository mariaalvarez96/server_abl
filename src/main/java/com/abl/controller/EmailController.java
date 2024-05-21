package com.abl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abl.EmailConfig;
import com.abl.entity.User;

@RestController
public class EmailController extends EmailConfig{

	private final JavaMailSender emailSender;

	public EmailController(JavaMailSender emailSender) {
		this.emailSender = emailSender;
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail() {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("maria.alvarez9296@gmail.com");
			message.setSubject("Este correo electrónico es de prueba");
			message.setText("Enviado desde mi aplicación Spring Boot.");

			emailSender.send(message);
			return ResponseEntity.ok().body("Correo enviado");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al enviar el correo electrónico: " + e.getMessage());
		}
	}
}
