package com.challenge.apicars.presentation.controllers.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apicars.application.services.authorization.AuthorizationService;
import com.challenge.apicars.application.services.authorization.model.Login;
import com.challenge.apicars.domain.entities.user.UserDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
	@Autowired
	AuthorizationService authorizationService;

	@Operation(description = "Logar usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário logado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Usuário ou senha inválidos!")
    })
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody @Valid Login data) {
		return authorizationService.login(data);
	}

	@Operation(description = "Cadastra um novo usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário cadastrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Usuário já está cadastrado!")
    })
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody @Valid UserDTO newUser) {
		return authorizationService.register(newUser);
	}
}