package com.jump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.exception.AppointmentNotFound;
import com.jump.model.Appointment;
import com.jump.repository.AppointmentsRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentsRepository appointmentRepository;
	
	public List<Appointment> getAppointments()
	{
		return appointmentRepository.findAll();
	}
	
	public Appointment addAppointment(Appointment appointment) 
	{
		return appointmentRepository.save(appointment);
	}
	
	public Appointment getAppointment(Integer appointmentId)
	{
		return appointmentRepository
				.findById(appointmentId)
				.orElseThrow(AppointmentNotFound::new);
	}
	
	public Appointment updateAppointment(Appointment appointment) 
	{
		getAppointment(appointment.getAppointmentId());
		return appointmentRepository.save(appointment);
	}
	
	public void deleteAppointment(Integer appointmentId)
	{
		getAppointment(appointmentId);
		appointmentRepository.deleteById(appointmentId);
	}

	

}
