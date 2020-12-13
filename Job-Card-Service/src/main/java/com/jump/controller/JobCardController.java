package com.jump.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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

import com.jump.model.Task;
import com.jump.repository.TaskRepository;
import com.jump.service.JobCardService;

@CrossOrigin(origins = "http://localhost:3000") 

//this wil be taken care of by zuul later
// ignoredHeaders: Access-Control-Allow-Credentials, Access-Control-Allow-Origin
@RestController
@RequestMapping("jobcard")
public class JobCardController {
	
	@Autowired
	JobCardService jobcardService;
	
	
	
	@Autowired
	TaskRepository taskRepository;
	
	

//@ApiOperation(notes = "This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.", value = "Get Todos")
	
	@GetMapping
	public ResponseEntity<List<JobCard>> getJobCards()
	{	
		return ResponseEntity.ok(jobcardService.retrieveJobCards());
	}
	
	@GetMapping("/{jobId}")
	public ResponseEntity<?> getJobCardByJobId(@PathVariable int jobId)
	{	
		Optional<JobCard> result = jobcardService.retrieveJobCardById(jobId);
		return ResponseEntity.ok(result);
	}
	
	//get all the  jobcards for the customer with the customer id in the api call
		@GetMapping("/customer/{customerId}")
		//get all the jobcards by employeeid
		
		public List<JobCard> findJobCardsByCustomerId(@PathVariable Integer customerId){
			
			return jobcardService.retrieveJobCardsByCustomerId(customerId);
			
		}

	
	//get all the  jobcards for the employee with the employee id in the api call
	@GetMapping("/employee/{employeeId}")
	//get all the jobcards by employeeid
	
	public List<JobCard> findJobCardsByEmployeeId(@PathVariable Integer employeeId){
		
		return jobcardService.retrieveJobCardsByEmployeeId(employeeId);
		
	}
	
	//get all the  jobcards for the appointment with the appointment id in the api call
		@GetMapping("/appointment/{appointmentId}")
		//get all the jobcards by employeeid
		
		public List<JobCard> findJobCardsByAppointmentId(@PathVariable Integer appointmentId){
			
			return jobcardService.retrieveJobCardsByAppointmentId(appointmentId);
			
		}
		
		//	@OneToMany(fetch = FetchType.LAZY ,cascade=CascadeType.ALL, orphanRemoval=true) this code takes care of put and delete 
		
	
	
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
	
	
	@PutMapping("/{jobId}")
	public ResponseEntity<?> updateJobCard(@PathVariable int jobId,@RequestBody JobCard jobcard)
	{
		if(jobId == jobcard.getJobId())
		{
			jobcardService.updateJobCard(jobcard);
			return ResponseEntity.ok("Updated!");
		}
		else
			throw new JobIdIDMismatchException();
			
	}
	
	
	
	
	//the entire thing above was waste of time !!!!!!!!!!!!!! FUDGGGGGGGEEEEEEEEEEEEEEE !!!
	@DeleteMapping("/{jobId}")
	public ResponseEntity<?> deleteJobCard(@PathVariable int jobId)
	{
		jobcardService.deleteJobCard(jobId);
		return ResponseEntity.noContent().build();
	}


}

/*
@DeleteMapping //what a pathetic way of deleting !!! 
public ResponseEntity<?> deleteJobCard(@RequestBody JobCard jobcard)
{
	
	//return ResponseEntity.noContent().build();
	
	//get the tasks for that job card which is in the list and method provided by lombok
			List<Task> tasks = jobcard.getTasks();
			
			//delete each task by id, once you finish deleting all tasks , delete the jobcard
			for(Task task : tasks) {
				//this is same as using the service class and using the save method of jparepository in there 
				//deleteById is a jpaprovided method that you can open the declaration and see
				taskRepository.deleteById(task.getTaskId());
			}
		
			
			jobcardService.deleteJobCard(jobcard.getJobId());
			//result.setTasks(taskRepository.findAllByJobId(result.getJobId()));
			
			return ResponseEntity
					.noContent()
					.build();
					
}


	/*
@PostMapping
public ResponseEntity<JobCard> addJobCard(@RequestBody JobCard jobcard) 
{	
	//get the tasks for that job card which is in the list and method provided by lombok
	List<Task> tasks = jobcard.getTasks();
	
	for(Task task : tasks) {
		//this is same as using the service class and using the save method of jparepository in there 
		taskRepository.save(task);
	}
	
	JobCard result= jobcardService.addJobCard(jobcard);
	result.setTasks(taskRepository.findAllByJobId(result.getJobId()));
	
	URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(result.getJobId())
			.toUri();
	
	return ResponseEntity
			.created(location)
			//.build();
			.body(result);
	
}
*/
/*
@GetMapping("customer/{customerId}")
//get all the  jobcards for the customer with the customer id in the api call
public Optional<JobCard> getJobCardsByCustomerId(@PathVariable int customerId)
{	
	//return jobcardService.retrieveJobCardByCustomerId(customerId);
	return jobcardService.retrieveJobCardByCustomerId(customerId);
	
} 
//code for embeddable : https://www.youtube.com/watch?v=pWqC0CvDnZc

*/