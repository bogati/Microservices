//added later -bimala 
package com.jump.service;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jump.model.Vehicle;


//there is no implementation like the controller class, the implementation is done by feign 
//fallback = VehicleServiceImpl.class 
@FeignClient(name = "vehicle-service")
public interface VehicleService {

	@PostMapping("vehicle")
	Vehicle addVehicle(@RequestBody Vehicle vehicle);
    
	
	
	//check your assumptions here 
	@GetMapping(value = "vehicle/customer/{customerId}")
	List<Vehicle> findVehiclesByCustomer(@PathVariable Integer customerId);
	

}