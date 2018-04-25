package com.soshiant.service.customer;


import com.soshiant.model.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {

    public Customer addNewCustomer(Customer customer);

    public Customer findByCustomerId(long customerId);

    public List<Customer> getAllCustomers();

    public List<Customer> findByLastName(String lastName);

    public List<Customer> findByEmailAddress(String emailAddress);

    public List<Customer> findByPhoneNumber(String phoneNumber);

}
