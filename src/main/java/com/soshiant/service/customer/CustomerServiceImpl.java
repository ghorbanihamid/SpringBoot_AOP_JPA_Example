package com.soshiant.service.customer;


import com.soshiant.model.customer.Customer;
import com.soshiant.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {



    @Autowired
    private CustomerRepository customerRepository;

    //==================================================================================================================
    @Transactional
    public Customer addNewCustomer(Customer customer) {

        try {
            Date date = new Date();
            customer.setCreateDate(date);
            Customer savedCustomer = customerRepository.save(customer);
            System.out.print("Id : " + savedCustomer.getCustomerId());
            return savedCustomer;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Customer> getAllCustomers() {

        try {
            List<Customer> customerList = customerRepository.findAll();
            return customerList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public Customer findByCustomerId(long customerId) {

        try {
            Optional<Customer> customer =  customerRepository.findById(customerId);
            return customer.get();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Customer> findByLastName(String lastName) {

        try {
            List<Customer> customerList = customerRepository.findByLastName(lastName);
            System.out.print("Number of customers found: " + customerList.size());
            return customerList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Customer> findByEmailAddress(String emailAddress) {

        try {
            List<Customer> customerList = customerRepository.findByEmailAddress(emailAddress);
            System.out.print("Number of customers found: " + customerList.size());
            return customerList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Customer> findByPhoneNumber(String phoneNumber) {

        try {
            List<Customer> customerList = customerRepository.findByPhoneNumber(phoneNumber);
            System.out.print("Number of customers found: " + customerList.size());
            return customerList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //======================================================================================================================
}

