package com.challenge.apicars.domain.entities.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import com.challenge.apicars.domain.entities.car.Car;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private LocalDate birthday;
	private LocalDateTime lastLogin;
	private LocalDateTime createdAt;
	
	@Column(unique = true)
	private String login;
	
	private String password;
	private String phone;
	
	@OneToMany(mappedBy = "owner")
	private List<Car> cars = new ArrayList<Car>();
}
