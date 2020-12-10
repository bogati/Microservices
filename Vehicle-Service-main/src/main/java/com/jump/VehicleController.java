package com.jump;

import java.util.List;
import javax.validation.Valid;
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

	@PostMapping()
	public ResponseEntity<String> addVehicle(@Valid @RequestBody Vehicle vehicle) {

		if (service.existsVehicleByVin(vehicle.getVin())) {
			return ResponseEntity.status(400).body("Vehicle with VIN = " + vehicle.getVin() + " already exists");
		} else {
			Vehicle created = service.save(vehicle);
			return ResponseEntity.status(201).body("Created: " + created);
		}

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

}
