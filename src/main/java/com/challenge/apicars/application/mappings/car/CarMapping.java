package com.challenge.apicars.application.mappings.car;

import org.springframework.stereotype.Service;

import com.challenge.apicars.domain.entities.car.Car;
import com.challenge.apicars.domain.entities.car.CarDTO;

@Service
public class CarMapping {
	public CarDTO toDTO(Car car) {
		CarDTO carDTO = new CarDTO(car);
        return carDTO;
    }
	
	public Car toCar(CarDTO carDTO) {
		Car car = new Car(carDTO);
        return car;
    }
}
