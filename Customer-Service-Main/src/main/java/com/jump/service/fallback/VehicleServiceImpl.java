
package com.jump.service.fallback;

import java.util.List;

import org.springframework.stereotype.Component;


import com.jump.model.Vehicle;
import com.jump.service.VehicleService;


@Component
public class VehicleServiceImpl implements VehicleService {

	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// the mileage make it double
		return new Vehicle("vin abc","toyota","camry",2005,10002,"red",000);
	}

	@Override
	public List<Vehicle> findVehiclesByCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		//return List.of(new Vehicle("vin abc","toyota","camry",2005,10002,"red"));
		return null;
	}

}
