package com.challenge.apicars.application.services.user.model;

import java.time.LocalDate;

public record UpdateUser(String firstName, String lastName, String email, LocalDate birthday, String phone) {
}
