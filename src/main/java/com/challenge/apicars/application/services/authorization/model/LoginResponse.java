package com.challenge.apicars.application.services.authorization.model;

public record LoginResponse(String token, String firstName, Long id) {
}
