package com.challenge.apicars.presentation.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apicars.application.services.user.UserService;
import com.challenge.apicars.domain.entities.user.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(this.service.findAllUsers());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable @Valid Long id) throws Exception {
		return ResponseEntity.ok(this.service.findUserById(id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable @Valid Long id) throws Exception {
		this.service.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
