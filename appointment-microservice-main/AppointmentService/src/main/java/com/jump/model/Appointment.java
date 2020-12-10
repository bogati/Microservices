package com.jump.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer appointmentId;
	
	@Column(name = "CUSTOMERID")
	Integer customerId;
	
	@Column(name = "SERVICEDATE")
	LocalDate serviceDate;
	
	@Column(name = "STOREID")
	Integer storeId;

}
