package com.jump;

import java.net.URI;
import java.util.List;

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





@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("vehicle")
@RestController
public class VehicleController {

	@Autowired
	VehicleRepository service;

	@GetMapping()
	public List<Vehicle> allVehicle() {
		return service.findAll();
	}
	/*
	 * Method from the interface Vehicle Service
	@GetMapping(value = "vehicle/customer/{customerId}")
	List<Vehicle> findVehiclesByCustomer(@PathVariable Integer customerId);
	IMPLEMENTATION BELOW 
	*/
	
	//find all the vehicles of a given customer , basically , find all the vehicles by customerid
	@GetMapping("customer/{customerId}" )
	public List<Vehicle> findVehiclesByCustomerId(@PathVariable Integer customerId) {
		return service.findAllByCustomerId(customerId);
	}
	
	
	/* OLDER VERSION OF POST 

	@PostMapping()
	public ResponseEntity<String> addVehicle(@Valid @RequestBody Vehicle vehicle) {

		if (service.existsVehicleByVin(vehicle.getVin())) {
			return ResponseEntity.status(400).body("Vehicle with VIN = " + vehicle.getVin() + " already exists");
		} else {
			Vehicle created = service.save(vehicle);
			return ResponseEntity.status(201).body("Created: " + created);
		}

	}
	*/
	//NEWER VERSION OF THE POST
	@PostMapping
	public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
		Vehicle result = service.save(vehicle);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getVin()).toUri();
		return ResponseEntity.created(location).body(result);

	}
	
	
	
	@DeleteMapping("/{vin}")
	public ResponseEntity<String> deleteVehicle(@PathVariable String vin) {
		if(service.existsVehicleByVin(vin)) {
			service.deleteById(vin);
			return ResponseEntity.status(200)
					.body("Deleted Vehicle with VIN = " + vin);
		}
		else {
			
			return ResponseEntity.status(400)
					.body("Vehicle with VIN = " + vin + " cannot be deleted because they don't exist");
		}
		
	}
	
	@PutMapping("/{vin}")
	public ResponseEntity<String> updateVehicle(@PathVariable String vin, @RequestBody Vehicle vehicle) {
		if(service.existsVehicleByVin(vin)) {
		service.save(vehicle);
		return ResponseEntity.status(200)
				.body("Updated Vehicle with VIN = " + vin);
		}
		else {
			return ResponseEntity.status(400)
					.body("Vehicle with VIN = " + vin + " cannot be updated because they don't exist");
		}
	}
	
	//added later for implementations for the vehicle 
	//the logic that i earlier used that vehicle controller has nothing to do with implementation is 
	//because the class does not have extend in the definiton 
	/*
	 * this implementation of the function in vehicleservice is taken care of by regular post above)
	@PostMapping("vehicle")
	Vehicle addVehicle(@RequestBody Vehicle vehicle);
    */
	
	/*
	//check your assumptions here  and the method is implemented at the top 
	@GetMapping(value = "vehicle/customer/{customerId}")
	List<Vehicle> findVehiclesByCustomer(@PathVariable Integer customerId);
	*/
}
