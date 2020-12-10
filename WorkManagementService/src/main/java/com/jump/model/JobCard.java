package com.jump.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class JobCard {
	
	@Id
	@GeneratedValue
	@Column(name="JOBID")
	Integer jobId;
	
	@Column(name="EMPLOYEEID")
	Integer employeeId;
	
	@Column(name="CUSTOMERID")
	Integer customerId;
	
	@Column(name="APPOINTMENTID")
	Integer appointmentId;
	
	@Column(name="VIN")
	@NotNull // the camelCase use by JPA
	String vechVin;
	
	//@JoinColumn(name = "post_id") 
	//one to many relationship with Service class 
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "JOBID")
	
	Set<Service> services ;
	
	
}
