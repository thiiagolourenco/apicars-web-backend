package com.challenge.apicars.presentation.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.apicars.application.services.user.UserService;
import com.challenge.apicars.application.services.user.model.UpdateUser;
import com.challenge.apicars.domain.entities.user.UserDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@Operation(description = "Lista todos os usuário do sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de usuário.")
    })
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(this.service.findAllUsers());
	}

	@Operation(description = "Busca um usuário a partir do seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuário buscado."),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado.")
    })
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable @Valid Long id) throws Exception {
		return ResponseEntity.ok(this.service.findUserById(id));
	}

	@Operation(description = "Edita um usuário a partir do seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário editado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado!")
    })
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> updateUserById(@PathVariable @Valid Long id, @RequestBody @Valid UpdateUser data)
			throws Exception {
		return new ResponseEntity<UserDTO>(this.service.updateUserById(id, data), HttpStatus.OK);
	}

	@Operation(description = "Apaga um usuário a partir do seu Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário removido com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado!")
    })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable @Valid Long id) throws Exception {
		this.service.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
