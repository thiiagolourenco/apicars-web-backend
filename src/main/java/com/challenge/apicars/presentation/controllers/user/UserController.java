package com.challenge.apicars.presentation.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apicars.application.services.user.UserService;
import com.challenge.apicars.domain.entities.user.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	/*
	 * @Autowired private UserService service;
	 * 
	 * @PostMapping public ResponseEntity<UserDTO> singUp(@RequestBody UserDTO
	 * newUser) { return new ResponseEntity<UserDTO>(this.service.singUp(newUser),
	 * HttpStatus.CREATED); }
	 */
}
