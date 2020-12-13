package com.jump.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data //for Lombok

//@Embeddable //we are not using entity because we are not going to create a separate table
@Entity 
public class Task {
	
	@Id
    @GeneratedValue
    @Column(name="TASKID",unique=true)
	Integer taskId;
	
	//with embeddable you will not have a Task table which is the main goal
	

	@Column(name="NAME")
	String name;
	@Column(name="PRICE")
	Double price;
	@Column(name="JOBID")
	Integer jobId;
	
	
	
	//foreign key is JOBID (optional = false, cascade = CascadeType.PERSIST)
	//referencedColumnName = "TASKID" //ADDITIONAL PARAMETER
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="JOBID" ,insertable = false, updatable = false)
	//@PrimaryKeyJoinColumn(name = "JOBID")
	JobCard jobcard;
	
	
	
	

}
