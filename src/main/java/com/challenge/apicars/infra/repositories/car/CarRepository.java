package com.challenge.apicars.infra.repositories.car;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apicars.domain.entities.car.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	public Optional<Car> findCarById(Long id);
}
