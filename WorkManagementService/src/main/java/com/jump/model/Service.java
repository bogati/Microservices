package com.jump.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




import lombok.Data;

@Data //for Lombok
@Entity
public class Service {
	@Id
    @GeneratedValue
    @Column(name="SERVICEID")
	Integer serviceId;
	@Column(name="NAME")
	String name;
	@Column(name="PRICE")
	String price;
	
	

}
