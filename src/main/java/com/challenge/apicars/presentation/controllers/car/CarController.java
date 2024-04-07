package com.challenge.apicars.presentation.controllers.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<List<CarDTO>> findCarByOwner(@PathVariable @Valid Long userId) throws Exception {
		return ResponseEntity.ok(this.service.findCarByUser(userId));
	}
}
