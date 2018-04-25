package com.soshiant.repository.customer;


import com.soshiant.model.customer.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAll();

    List<Customer> findByCustomerId(String customerId);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByEmailAddress(String emailAddress);

    List<Customer> findByPhoneNumber(String phoneNumber);

}
