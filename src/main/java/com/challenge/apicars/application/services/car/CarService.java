package com.challenge.apicars.application.services.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.apicars.application.mappings.car.CarMapping;
import com.challenge.apicars.application.services.user.UserService;
import com.challenge.apicars.domain.entities.car.Car;
import com.challenge.apicars.domain.entities.car.CarDTO;
import com.challenge.apicars.domain.entities.user.User;
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
	
	@Transactional(readOnly = true)
	public CarDTO findCarById(Long carId) throws Exception {
		Optional<Car> foundedCar = this.carRepository.findCarById(carId);
		if (!foundedCar.isEmpty()) {
			return this.mapping.toDTO(foundedCar.get());
		} else {
			throw new Exception("Car not found!");
		}
	}
	
	public void deleteCarById(Long carId) throws Exception {
		this.carRepository.deleteById(carId);
	}
	
	public CarDTO updateCarById(Long carId, CarDTO newCar) throws Exception {
		Optional<Car> pastCar = this.carRepository.findCarById(carId);
		if (!pastCar.isEmpty()) {
			Car editedCar = pastCar.get();
			
			editedCar.setUser(new User(newCar.getUser()));
			editedCar.setYeear(newCar.getYeear());
			editedCar.setLicensePlate(newCar.getLicensePlate());
			editedCar.setModel(newCar.getModel());
			editedCar.setColor(newCar.getColor());
			
			Car savedCar = this.carRepository.save(editedCar);
			return this.mapping.toDTO(savedCar);
		} else {
			throw new Exception("Unable to edit the car data!");
		} 
	}
}
