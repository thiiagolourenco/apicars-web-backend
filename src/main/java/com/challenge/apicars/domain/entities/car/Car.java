package com.challenge.apicars.domain.entities.car;

import java.io.Serializable;

import com.challenge.apicars.domain.entities.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="cars")
@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	private Integer yeear;
	
	@Column(unique = true)
	private String licensePlate;
	
	
	private String model;
	private String color;
	
	public Car(CarDTO carDTO) {
		this.id = carDTO.getId();
		this.user = new User(carDTO.getUser());
		this.yeear = carDTO.getYeear();
		this.licensePlate = carDTO.getLicensePlate();
		this.model = carDTO.getModel();
		this.color = carDTO.getColor();
	}
}
