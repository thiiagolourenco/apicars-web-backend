package com.challenge.apicars.domain.entities.car;

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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="cars")
@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User owner;
	
	private Integer year;
	
	@Column(unique = true)
	private String licensePlate;
	
	
	private String model;
	private String color;
}
