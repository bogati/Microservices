package com.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.model.Task;

import com.jump.model.JobCard;
import com.jump.repository.JobCardRepository;

@Service
public class JobCardService {
	
	@Autowired
	JobCardRepository jobcardRepository;
	//get  
	public List<JobCard> retrieveJobCards()
	{
		//using the builtin finaAll method method provided by jpa
		return jobcardRepository.findAll();
		
	}
	//get 
	public Optional<JobCard> retrieveJobCardById(int jobId)
	{
		return jobcardRepository.findById(jobId);
	}
	/*
	public Optional<JobCard> retrieveJobCardByCustomerId(int customerId) {
		return jobcardRepository.findById(customerId);
	}*/
	
	//get
	public List<JobCard> retrieveJobCardsByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return jobcardRepository.findAllByCustomerId(customerId);
	}
	
	//get
	public List<JobCard> retrieveJobCardsByEmployeeId(Integer employeeId) {
		// TODO Auto-generated method stub
		return jobcardRepository.findAllByEmployeeId(employeeId);
	}
	
	//get
	public List<JobCard> retrieveJobCardsByAppointmentId(Integer appointmentId) {
		// TODO Auto-generated method stub
		return jobcardRepository.findAllByAppointmentId(appointmentId);
	}

	//post
	public JobCard addJobCard(JobCard jobcard) {
		// TODO Auto-generated method stub
		return jobcardRepository.save(jobcard);
	}


	//put
	public boolean updateJobCard(JobCard jobcard) {
		retrieveJobCardById(jobcard.getJobId());
		return jobcardRepository.save(jobcard) != null;
		
	}


	//delete
	public boolean deleteJobCard(int id) {
		retrieveJobCardById(id);
		jobcardRepository.deleteById(id);
		return true;
		
	}







}
