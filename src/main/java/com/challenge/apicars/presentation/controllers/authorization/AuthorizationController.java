package com.challenge.apicars.presentation.controllers.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apicars.application.services.authorization.AuthorizationService;
import com.challenge.apicars.domain.entities.user.UserDTO;
import com.challenge.apicars.infra.security.model.Login;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
	@Autowired
	AuthorizationService authorizationService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody @Valid Login data) {
		return authorizationService.login(data);
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody @Valid UserDTO newUser) {
		return authorizationService.register(newUser);
	}
}