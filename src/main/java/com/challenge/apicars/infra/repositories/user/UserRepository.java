package com.challenge.apicars.infra.repositories.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apicars.domain.entities.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
