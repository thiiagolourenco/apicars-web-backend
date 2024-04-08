package com.challenge.apicars.infra.repositories.authorization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.challenge.apicars.domain.entities.user.User;

public interface AuthorizationRepository extends JpaRepository<User, Long> {
	public UserDetails findByLogin(String login);
}

