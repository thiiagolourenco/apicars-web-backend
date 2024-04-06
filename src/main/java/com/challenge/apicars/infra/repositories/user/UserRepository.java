package com.challenge.apicars.infra.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apicars.domain.entities.user.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findUserById(String id);
}
