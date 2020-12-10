package com.jump.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jump.model.Appointment;
import com.jump.service.AppointmentService;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping
	public List<Appointment> getAllAppointments()
	{
		logger.info("Listing all appointments");
		return appointmentService.getAppointments();
	}
	
	@GetMapping("/{appointmentId}")
	public Appointment getAppointmentById(@PathVariable Integer appointmentId)
	{
		logger.info("Finding your appointment: " + appointmentId);
		return appointmentService.getAppointment(appointmentId);
	}
	
	@PostMapping()
	public Appointment addAppointment(@RequestBody Appointment appointment)
	{
		logger.info("Adding new appointment: " + appointment);
		return appointmentService.addAppointment(appointment);
	}
	
	@PutMapping("/{appointmentID}")
	public Appointment updateAppointment(@PathVariable Integer accountId, @RequestBody Appointment appointment) 
	{
		logger.info("Finding and updating appointment :" + appointment);
		return appointmentService.updateAppointment(appointment);
	}
	
	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<?> deleteAppointment(@PathVariable Integer appointmentId)
	{
		logger.info("Delete by appointment ID:" + appointmentId);
		appointmentService.deleteAppointment(appointmentId);
		return ResponseEntity.noContent().build();
	}
}
