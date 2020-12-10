package com.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jump.model.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, Integer> {

}
