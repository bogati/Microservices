package com.jump.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicle {
	
	 String vin;
	 String brand;
	 String model;
	 Integer year;
	 Integer mileage;
	 String color;
	 Integer customerId;

}
