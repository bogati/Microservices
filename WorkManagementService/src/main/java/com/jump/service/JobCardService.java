package com.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.model.JobCard;
import com.jump.repository.JobCardRepository;

@Service
public class JobCardService {
	
	@Autowired
	JobCardRepository jobcardRepository;
	
	public List<JobCard> retrieveJobCards()
	{
		//using the builtin finaAll method method provided by jpa
		return jobcardRepository.findAll();
		
	}
	

	
	public Optional<JobCard> retrieveJobCardById(int id)
	{
		return jobcardRepository.findById(id);
	}



	public JobCard addJobCard(JobCard jobcard) {
		// TODO Auto-generated method stub
		return jobcardRepository.save(jobcard);
	}



	public boolean updateJobCard(JobCard jobcard) {
		retrieveJobCardById(jobcard.getJobId());
		return jobcardRepository.save(jobcard) != null;
		
	}



	public boolean deleteJobCard(int id) {
		retrieveJobCardById(id);
		jobcardRepository.deleteById(id);
		return true;
		
	}


}
