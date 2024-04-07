package com.challenge.apicars.domain.entities.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.challenge.apicars.domain.entities.car.CarDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private LocalDateTime lastLogin;
	private LocalDateTime createdAt;
	private String login;
	private UserRole role;
	private String password;
	private String phone;
	private List<CarDTO> cars = new ArrayList<CarDTO>();

	public UserDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.birthday = user.getBirthday();
		this.lastLogin = user.getLastLogin();
		this.createdAt = user.getCreatedAt();
		this.login = user.getLogin();
		this.role = user.getRole();
		this.password = user.getPassword();
		this.phone = user.getPhone();
		this.cars= user.getCars().stream().map(car -> new CarDTO(car)).collect(Collectors.toList());
	}
}
