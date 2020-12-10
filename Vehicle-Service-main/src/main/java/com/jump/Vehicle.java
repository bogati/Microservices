package com.jump;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -8495512695594854131L;
	
		@Id
		private String vin;
		private String brand;
		private String model;
		private Integer year;
		private Integer mileage;
		private String color;
		
		//default constructor
		public Vehicle() {
			this("N/A", "N/A","N/A", 1000, -1, "N/A");
		}
		
		public Vehicle(String vin, String brand, String model, Integer year, Integer mileage, String color) {
			super();
			this.vin = vin;
			this.brand = brand;
			this.model = model;
			this.year = year;
			this.mileage = mileage;
			this.color = color;
		}
		
		public String getVin() {
			return vin;
		}
		public void setVin(String vin) {
			this.vin = vin;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
		public Integer getMileage() {
			return mileage;
		}
		public void setMileage(Integer mileage) {
			this.mileage = mileage;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		@Override
		public String toString() {
			return "vehicle [vin=" + vin + ", brand=" + brand + ", model=" + model + ", year=" + year
					+ ", mileage=" + mileage + ", color=" + color + "]";
		}
}
