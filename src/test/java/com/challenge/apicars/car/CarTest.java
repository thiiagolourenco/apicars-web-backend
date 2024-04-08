package com.challenge.apicars.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.challenge.apicars.domain.entities.car.Car;
import com.challenge.apicars.domain.entities.car.CarDTO;
import com.challenge.apicars.domain.entities.user.User;
import com.challenge.apicars.domain.entities.user.UserDTO;
import com.challenge.apicars.domain.entities.user.UserRole;
import com.challenge.apicars.infra.repositories.car.CarRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class CarTest {

	@Autowired
	CarRepository carRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	@DisplayName("Should get Car successfully")
	void findCarByIdSuccess() {
		UserDTO userData = new UserDTO(
        		(long) 1,
        		"Thiago",
        		"Lourenço",
        		"thiago@teste.com",
        		LocalDate.now(),
        		LocalDateTime.now(),
        		LocalDateTime.now(),
        		"thiagologin",
        		UserRole.ADMIN,
        		"123456789",
        		"81987654533",
        		new ArrayList<CarDTO>()
        		);
        
        this.entityManager.persist(new User(userData));
		
		
		CarDTO carData = new CarDTO((long) 1, (long) 1, 2020, "QH6H98", "HB20S", "AZUL");

		this.entityManager.persist(new Car(carData));

		Optional<Car> result = this.carRepository.findCarById((long) 1);

		assertThat(result.isPresent()).isTrue();
	}

	@Test
	@DisplayName("Shouldn't get Car")
	void findCarByIdError() {
		Optional<Car> result = this.carRepository.findCarById((long) 1);

		assertThat(result.isEmpty()).isTrue();
	}
}
