package com.jump.model;






import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="JOBCARD")
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

	
	//@OneToMany(mappedBy="JOBCARD")
	@OneToMany(fetch = FetchType.LAZY ,cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="JOBID") 
	List<Task> tasks ;
	
	
	}
	
	
	
	
	
	
	
	
	
	/*
	 //one to many relationship with Service class 
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "JOBID")
	//@JoinColumn(name = "JOBID", referencedColumnName = "JOBID")
	//jobcard being the owning side/parent while task being referencing side/child side of the relationship
	@Transient
	List <Vehicle> vehicles;
	
	@Transient
	List <Appointment> appointments;
	
	@Transient
	List <Customer> customers;
	
	REFERENCE ARTICLE:
	https://stackabuse.com/a-guide-to-jpa-with-hibernate-relationship-mapping/
	https://www.baeldung.com/hibernate-one-to-many
	
	
	the main article with the working code
	https://www.baeldung.com/hibernate-one-to-many 
	
	working code for embeddable
	https://www.baeldung.com/jpa-embedded-embeddable
	*/
	
	

