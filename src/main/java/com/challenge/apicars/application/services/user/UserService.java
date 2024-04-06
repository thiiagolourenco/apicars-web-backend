package com.challenge.apicars.application.services.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true)
	public List<UserDTO> findAllUsers() {
		List<User> users = this.repository.findAll();
		return users.stream().map(user -> this.mapping.toDTO(user)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public UserDTO findUserById(Long userId) throws Exception {
		Optional<User> foundedUser = this.repository.findUserById(userId);
		if (!foundedUser.isEmpty()) {
			return this.mapping.toDTO(foundedUser.get());
		} else {
			throw new Exception("Usuário não foi encontrado!");
		}
	}
}
