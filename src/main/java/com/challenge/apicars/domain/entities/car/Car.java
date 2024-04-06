package com.challenge.apicars.domain.entities.car;

import java.io.Serializable;

import com.challenge.apicars.domain.entities.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User owner;
	
	private Integer car_year;
	
	@Column(unique = true)
	private String licensePlate;
	
	
	private String model;
	private String color;
}
