package com.challenge.apicars.presentation.controllers.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.apicars.application.services.car.CarService;
import com.challenge.apicars.domain.entities.car.CarDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {
	@Autowired
	private CarService service;

	@Operation(description = "Cria um carro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Carro já está cadastrado!")
    })
	@PostMapping
	public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO carDTO) throws Exception {
		return new ResponseEntity<CarDTO>(this.service.createCar(carDTO), HttpStatus.CREATED);
	}

	@Operation(description = "Busca os carros a partir do id do seu proprietário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de carros do usuário."),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado.")
    })
	@GetMapping(value = "/by-user/{userId}")
	public ResponseEntity<List<CarDTO>> findCarByUser(@PathVariable @Valid Long userId)
			throws Exception {
		return ResponseEntity.ok(this.service.findCarByUser(userId));
	}

	@Operation(description = "Busca um carro a partir do seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o carro buscado."),
            @ApiResponse(responseCode = "400", description = "Carro não encontrado.")
    })
	@GetMapping(value = "/{id}")
	public ResponseEntity<CarDTO> findCarById(@PathVariable @Valid Long id) throws Exception {
		return ResponseEntity.ok(this.service.findCarById(id));
	}

	@Operation(description = "Edita um carro a partir do seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro editado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Carro não encontrado!")
    })
	@PutMapping(value = "/{id}")
	public ResponseEntity<CarDTO> updateCarById(@PathVariable @Valid Long id, @RequestBody @Valid CarDTO data)
			throws Exception {
		return new ResponseEntity<CarDTO>(this.service.updateCarById(id, data), HttpStatus.OK);
	}

	
	@Operation(description = "Apaga um carro a partir do seu id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro removido com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Carro não encontrado!")
    })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCarById(@PathVariable @Valid Long id) throws Exception {
		this.service.deleteCarById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
