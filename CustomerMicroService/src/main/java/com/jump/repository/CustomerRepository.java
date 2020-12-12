package com.jump.repository;

// import java.util.List;

import com.jump.model.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
  // List<Customer> findByLastName(String lastName);
}
