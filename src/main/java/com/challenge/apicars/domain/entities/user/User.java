package com.challenge.apicars.domain.entities.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.challenge.apicars.domain.entities.car.Car;

import jakarta.persistence.Entity;
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

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private String login;
	private String password;
	private String phone;
	
	private List<Car> cars = new ArrayList<Car>();
}
