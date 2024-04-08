package com.challenge.apicars.domain.entities.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	private Long id;
	private Long user;
	private Integer yeear;
	private String licensePlate;
	private String model;
	private String color;

	public CarDTO(Car car) {
		this.id = car.getId();
		this.user = car.getUser().getId();
		this.yeear = car.getYeear();
		this.licensePlate = car.getLicensePlate();
		this.model = car.getModel();
		this.color = car.getColor();
	}
}
