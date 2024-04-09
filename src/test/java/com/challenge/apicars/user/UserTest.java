package com.challenge.apicars.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.challenge.apicars.domain.entities.car.CarDTO;
import com.challenge.apicars.domain.entities.user.User;
import com.challenge.apicars.domain.entities.user.UserDTO;
import com.challenge.apicars.domain.entities.user.UserRole;
import com.challenge.apicars.infra.repositories.user.UserRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
@SpringBootTest(classes = UserTest.class)
public class UserTest {
	
    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get User successfully")
    void findUserByIdSuccess() {
        UserDTO data = new UserDTO(
        		(long) 1,
        		"Thiago",
        		"Lourenço",
        		"thiago@teste.com",
        		LocalDate.now(),
        		LocalDateTime.now(),
        		LocalDateTime.now(),
        		"thiagologin",
        		UserRole.ADMIN,
        		"123456789",
        		"81987654533",
        		new ArrayList<CarDTO>()
        		);
        
        this.entityManager.persist(new User(data));

        Optional<User> result = this.userRepository.findUserById((long) 1);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Shouldn't get User")
    void findUserByIdError() {
        Optional<User> result = this.userRepository.findUserById((long) 1);

        assertThat(result.isEmpty()).isTrue();
    }
}
