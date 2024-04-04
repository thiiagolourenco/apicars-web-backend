package com.challenge.apicars.domain.entities.car;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="car")
@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Car {

	private Integer year;
	private String licensePlate;
	private String model;
	private String color;
}
