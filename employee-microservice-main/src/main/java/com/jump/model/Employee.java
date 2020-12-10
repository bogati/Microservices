package com.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOYEES")
@Entity
@ToString
public class Employee {

	@Id//Primary key
	@Column(name="EMPLOYEEID")
	Integer employeeId;
	
	@Column(name="EMPLOYEELASTNAME")
	String employeeLastName;
	
	@Column(name="EMPLOYEEFIRSTNAME")
	String employeeFirstName;
	
	@Column(name="EMPLOYEEPHONENUMBER")
	String employeePhoneNumber;

	@Column(name="EMPLOYEETITLE")
	String employeeTitle;

}
