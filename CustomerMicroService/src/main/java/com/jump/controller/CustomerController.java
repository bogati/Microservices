package com.jump.controller;

import java.net.URI;
import java.util.List;


import com.jump.model.Customer;
import com.jump.model.Vehicle;
import com.jump.service.VehicleService;
import com.jump.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("customer")
public class CustomerController {

  @Autowired
  CustomerService customerService;
  
  //added later ---- bimala 
  //consuming the feignclient VehicleService here 
  @Autowired
  VehicleService vehicleService;
/*
  @GetMapping()
  public ResponseEntity<List<Customer>> getCustomers() {

    return ResponseEntity.ok(customerService.getCustomers());
  }
  */
  //added later -bimala 
  
	@GetMapping
	public Iterable<Customer> getCustomers() {

		List<Customer> customers = customerService.getCustomers();

		for (Customer c : customers) {
			c.setVehicles(vehicleService.findVehiclesByCustomer(c.getCustomerId()));
			
		}
		return customers;
	}
	/*
  @GetMapping("/{id}")
  public Customer getCustomer(@PathVariable("id") int id) {
    return customerService.getCustomerById(id);
  }
  */
	//added later -bimala 
  
  @GetMapping(value = "/{customerId}")
	public Customer getCustomerByVehicleId(@PathVariable Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		customer.setVehicles(vehicleService.findVehiclesByCustomer(customerId));
		return customer;
	}
  /*
  //original way of doing the post 
  @PostMapping()
  public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

    Customer result = customerService.addCustomer(customer);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
        .toUri();
    return ResponseEntity.created(location).body(result);

  }
  */
  //added later --- bimala 
  //new way of doing the post after using the feign client 
  
  @PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
	  //getVehicles is implemented by Lombok -fyi
		List<Vehicle> vehicles = customer.getVehicles();
		for (Vehicle vehicle : vehicles) {
			vehicleService.addVehicle(vehicle);
		}
		Customer result = customerService.addCustomer(customer);
	
		result.setVehicles(vehicleService.findVehiclesByCustomer(result.getCustomerId()));
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getCustomerId()).toUri();
		return ResponseEntity.created(location).body(result);
		
	}
/*
  @PutMapping("/{customerId}")
  public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {

    Customer result = customerService.updateCustomer(customer);

    return result;
  }
  */
  //added later   -Bimala 
  @PutMapping(value = "/{customerId}")
 	public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
 		 
 		Customer result = customerService.updateCustomer(customer);
 		result.setVehicles(vehicleService.findVehiclesByCustomer(customerId));
 		return result;
 	}

  
  @DeleteMapping("/{customerId}")
  public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
    customerService.deleteCustomer(customerId);
    return ResponseEntity.noContent().build();
  }
  
 



  
	

}
