package com.challenge.apicars.application.services.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.apicars.application.mappings.user.UserMapping;
import com.challenge.apicars.domain.entities.user.User;
import com.challenge.apicars.domain.entities.user.UserDTO;
import com.challenge.apicars.infra.repositories.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapping mapping;

	public List<UserDTO> findAllUsers() {
		List<User> users = this.repository.findAll();
		return users.stream().map(user -> this.mapping.toDTO(user)).collect(Collectors.toList());
	}
}
