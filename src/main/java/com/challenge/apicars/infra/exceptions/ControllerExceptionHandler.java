package com.challenge.apicars.infra.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.challenge.apicars.infra.exceptions.model.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionDTO> threatDuplicateUser(DataIntegrityViolationException exception) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("User already exists", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> threatNotFound(EntityNotFoundException exception) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> threatGeneralException(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }

}
