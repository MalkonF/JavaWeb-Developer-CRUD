package com.malkon.JavaWebDeveloperCRUD.resources.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(value = {IllegalArgumentException.class} )
	public ResponseEntity<StandardError> IllegalArgumentException(IllegalArgumentException e) throws Exception{
		StandardError err = new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}
