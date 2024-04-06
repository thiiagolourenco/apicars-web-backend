package com.challenge.apicars.application.mappings.user;

import org.springframework.stereotype.Service;

import com.challenge.apicars.domain.entities.user.User;
import com.challenge.apicars.domain.entities.user.UserDTO;

@Service
public class UserMapping {
	
	public UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }
	
	public User toUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return user;
    }
}
