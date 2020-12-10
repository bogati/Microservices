package com.jump.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Integer id;

  @Column(name = "FIRST_NAME")
  String firstName;

  @Column(name = "LAST_NAME")
  String lastName;

  @Column(name = "EMAIL")
  String email;

  @Column(name = "PHONE_NUMBER")
  String phoneNumber;

  @Column(name = "VIN")
  String vin;

}
