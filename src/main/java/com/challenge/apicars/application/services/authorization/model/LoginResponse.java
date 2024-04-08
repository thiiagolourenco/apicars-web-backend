package com.challenge.apicars.application.services.authorization.model;

import com.challenge.apicars.domain.entities.user.User;

public record LoginResponse(String token, User user) {
}
