package com.jump.service;

import java.util.ArrayList;
import java.util.List;

import com.jump.exception.CustomerNotFound;
import com.jump.model.Customer;
import com.jump.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  public Customer addCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  public List<Customer> getCustomers() {

    List<Customer> customers = new ArrayList<Customer>();
    customerRepository.findAll().forEach(customer -> customers.add(customer));
    return customers;
  }

  public Customer getCustomerById(Integer id) {

    return customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
  }

  public Customer updateCustomer(Customer customer) {

    getCustomerById(customer.getId());
    return customerRepository.save(customer);
  }

  public void deleteCustomer(Integer id) {
    getCustomerById(id);
    customerRepository.deleteById(id);

  }
}
