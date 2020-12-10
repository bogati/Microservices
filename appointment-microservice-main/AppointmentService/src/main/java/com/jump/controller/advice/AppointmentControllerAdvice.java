package com.jump.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jump.exception.AppointmentNotFound;

@RestControllerAdvice
public class AppointmentControllerAdvice {
	
	@ExceptionHandler(AppointmentNotFound.class)
	public ResponseEntity<?> handleAppointmentNotFound()
	
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointment not found!");
	}

}
