package com.jump;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	boolean existsVehicleByVin(String vin);
	
	//added later -bimala 
	List<Vehicle> findAllByCustomerId(Integer customerId);

}