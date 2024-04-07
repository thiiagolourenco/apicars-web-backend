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

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/cars")
public class CarController {
	@Autowired
	private CarService service;

	@PostMapping
	public ResponseEntity<CarDTO> createCar(@RequestBody @Valid CarDTO carDTO) throws Exception {
		return new ResponseEntity<CarDTO>(this.service.createCar(carDTO), HttpStatus.CREATED);
	}

	@GetMapping(value = "/by-user/{userId}")
	public ResponseEntity<List<CarDTO>> findCarByUser(@PathVariable @Valid Long userId)
			throws Exception {
		return ResponseEntity.ok(this.service.findCarByUser(userId));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CarDTO> findCarById(@PathVariable @Valid Long id) throws Exception {
		return ResponseEntity.ok(this.service.findCarById(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CarDTO> updateCarById(@PathVariable @Valid Long id, @RequestBody @Valid CarDTO data)
			throws Exception {
		return new ResponseEntity<CarDTO>(this.service.updateCarById(id, data), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCarById(@PathVariable @Valid Long id) throws Exception {
		this.service.deleteCarById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
