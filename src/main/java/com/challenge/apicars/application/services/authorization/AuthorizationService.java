package com.challenge.apicars.application.services.authorization;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.challenge.apicars.application.mappings.user.UserMapping;
import com.challenge.apicars.domain.entities.authorization.Login;
import com.challenge.apicars.domain.entities.authorization.LoginResponse;
import com.challenge.apicars.domain.entities.user.User;
import com.challenge.apicars.domain.entities.user.UserDTO;
import com.challenge.apicars.infra.repositories.authorization.AuthorizationRepository;
import com.challenge.apicars.infra.security.TokenService;

import jakarta.validation.Valid;

@Service
public class AuthorizationService implements UserDetailsService {
	@Autowired
	private ApplicationContext context;

	@Autowired
	private AuthorizationRepository authorizationRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserMapping mapping;

	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		return authorizationRepository.findByLogin(login);
	}

	public ResponseEntity<Object> login(@RequestBody @Valid Login data) {
		authenticationManager = context.getBean(AuthenticationManager.class);

		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		var token = tokenService.generateToken((User) auth.getPrincipal());
		return ResponseEntity.ok(new LoginResponse(token));
	}

	public ResponseEntity<Object> register(@RequestBody @Valid UserDTO newUser) {
		if (this.authorizationRepository.findByLogin(newUser.getLogin()) != null)
			return ResponseEntity.badRequest().build();
		String encryptedPassword = new BCryptPasswordEncoder().encode(newUser.getPassword());

		newUser.setCreatedAt(LocalDateTime.now());
		newUser.setPassword(encryptedPassword);

		this.authorizationRepository.save(this.mapping.toUser(newUser));

		return ResponseEntity.ok().build();
	}

}
