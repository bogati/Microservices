package com.jump.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jump.exception.JobIdIDMismatchException;
import com.jump.model.JobCard;
import com.jump.service.JobCardService;

@CrossOrigin(origins = "http://localhost:3000") 
//this wil be taken care of by zuul later
// ignoredHeaders: Access-Control-Allow-Credentials, Access-Control-Allow-Origin
@RestController
@RequestMapping("jobcard")
public class JobCardController {
	
	@Autowired
	JobCardService jobcardService;
	
	

//@ApiOperation(notes = "This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.", value = "Get Todos")
	
	@GetMapping
	public ResponseEntity<List<JobCard>> getJobCards()
	{	
		return ResponseEntity.ok(jobcardService.retrieveJobCards());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getJobCardById(@PathVariable int id)
	{	
		Optional<JobCard> result = jobcardService.retrieveJobCardById(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<JobCard> addJobCard(@RequestBody JobCard jobcard) throws URISyntaxException
	{	
	
		JobCard result= jobcardService.addJobCard(jobcard);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getJobId())
				.toUri();
		
		return ResponseEntity
				.created(location)
				.build();
				//.body(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateJobCard(@PathVariable int id,@RequestBody JobCard jobcard)
	{
		if(id == jobcard.getJobId())
		{
			jobcardService.updateJobCard(jobcard);
			return ResponseEntity.ok("Updated!");
		}
		else
			throw new JobIdIDMismatchException();
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobCard(@PathVariable int id)
	{
		jobcardService.deleteJobCard(id);
		return ResponseEntity.noContent().build();
	}

}
