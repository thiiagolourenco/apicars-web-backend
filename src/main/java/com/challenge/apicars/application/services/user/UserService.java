package com.challenge.apicars.application.services.user;

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

	public UserDTO singUp(UserDTO newUser) {
		User result = this.repository.save(this.mapping.toUser(newUser));
		return this.mapping.toDTO(result);
	}
}
