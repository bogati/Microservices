package com.jump.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;






@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CUSTOMERS")
@Entity
public class Customer {

 //change the naming convention later to customerId for consistency -Bimala 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Integer customerId;

  @Column(name = "FIRST_NAME")
  String firstName;

  @Column(name = "LAST_NAME")
  String lastName;

  @Column(name = "EMAIL")
  String email;

  @Column(name = "PHONE_NUMBER")
  String phoneNumber;

  /* the original idea was to have 1 vehicle per customer so just had vin 
  @Column(name = "VIN")
  String vin;
  */
  
  
  //use set later added later -bimala 
  @Transient
  List<Vehicle> vehicles;
  //setVehicles and getVehicles are coming from lombock -fyi
  

}
