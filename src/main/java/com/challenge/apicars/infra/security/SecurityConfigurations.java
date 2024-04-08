package com.challenge.apicars.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
	@Autowired
	SecurityFilter securityFilter;

	private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/users").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/users/{id}").permitAll()
						.requestMatchers(HttpMethod.DELETE, "/api/users/{id}").permitAll()
						.requestMatchers(HttpMethod.PUT, "/api/users/{id}").permitAll()
						.requestMatchers(SWAGGER_WHITELIST).permitAll()
						.anyRequest().authenticated())
						/*
						 * .requestMatchers(HttpMethod.POST, "/api/cars").permitAll()
						 * .requestMatchers(HttpMethod.GET, "/api/cars/by-user/{userId}").permitAll()
						 * .requestMatchers(HttpMethod.GET, "/api/cars/{id}").permitAll()
						 * .requestMatchers(HttpMethod.DELETE, "/api/cars/{id}").permitAll()
						 * .requestMatchers(HttpMethod.PUT, "/api/cars/{id}").permitAll()
						 */
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}