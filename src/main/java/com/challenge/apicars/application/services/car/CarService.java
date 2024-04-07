package com.challenge.apicars.application.services.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.apicars.application.mappings.car.CarMapping;
import com.challenge.apicars.application.services.user.UserService;
import com.challenge.apicars.domain.entities.car.Car;
import com.challenge.apicars.domain.entities.car.CarDTO;
import com.challenge.apicars.infra.repositories.car.CarRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CarMapping mapping;

	public CarDTO createCar(CarDTO carDTO) {
		Car result = this.carRepository.save(this.mapping.toCar(carDTO));
		return this.mapping.toDTO(result);
	}

	@Transactional(readOnly = true)
	public List<CarDTO> findCarByUser(Long userId) throws Exception {
		return this.userService.findUserById(userId).getCars();
	}
}
