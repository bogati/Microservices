package com.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//there is a builtin service class -be careful
import com.jump.model.Task;

import com.jump.model.JobCard;

@Repository
public interface JobCardRepository extends JpaRepository<JobCard,Integer>{
	
	
	List<JobCard> findAllByCustomerId(Integer customerId);
	
	List<JobCard> findAllByEmployeeId(Integer employeeId);
	
	List<JobCard> findAllByAppointmentId(Integer appointmentId);

}
 