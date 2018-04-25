package com.soshiant.controller.customer;


import com.soshiant.model.customer.Customer;
import com.soshiant.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/springmvc")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //============================== Url : http://localhost:8080/springmvc/showRegisterCustomer=============================
    @RequestMapping(value = "/showRegisterCustomer",method = RequestMethod.GET)
    public ModelAndView showRegisterCustomerForm()  {

        ModelAndView model = new ModelAndView("/customer/registerCustomer");
        return model;
    }
    //============================== Url : http://localhost:8080/springmvc/registerCustomer=================================
    @RequestMapping(value = "/registerCustomer",method = RequestMethod.POST)
    public ModelAndView registerNewCustomer(@RequestParam(value= "firstName",required = true) String firstName,
                                     @RequestParam(value= "lastName",required = true) String lastName,
                                     @RequestParam(value= "emailAddress",required = true) String emailAddress,
                                     @RequestParam(value= "phoneNumber",required = true) String phoneNumber) throws Exception {

        ModelAndView tempModel = new ModelAndView();
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmailAddress(emailAddress);
        customer.setPhoneNumber(phoneNumber);


        Customer resultData = customerService.addNewCustomer(customer);
        if (resultData != null) { // success
            tempModel.addObject("messageType", "success");
            tempModel.addObject("appMessage", "Customer Registered Successfully with customer Id : " + resultData.getCustomerId());
            tempModel.setViewName("appMessages");
            tempModel.setStatus(HttpStatus.OK);
        }
        else { // error
            tempModel.addObject("messageType", "error");
            tempModel.addObject("appMessage", "Error!!!, could not  Register Customer info ");
            tempModel.setViewName("appMessages");
            tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }
        return tempModel;
    }
    //============================== Url : http://localhost:8080/springmvc/showRegisterCustomer=========================
    @RequestMapping(value = "/showSearchCustomer",method = RequestMethod.GET)
    public ModelAndView showSearchCustomer()  {

        ModelAndView model = new ModelAndView("/customer/searchCustomer");
        model.addObject("messageType", "");
        model.addObject("appMessage", "");
        return model;
    }
    //============================== Url : http://localhost:8080/springmvc/registerCustomer=============================
    @RequestMapping(value = "/searchCustomer",method = RequestMethod.POST)
    public ModelAndView showSearchCustomerResult(@RequestParam(value= "fieldName",required = true) String fieldName,
                                                 @RequestParam(value= "fieldValue",required = true) String fieldValue)
                                                 throws Exception {

        ModelAndView tempModel = new ModelAndView();

        List<Customer> customerList = null;
        if( fieldName.equals("AllCustomers") ) {
            customerList = customerService.getAllCustomers();
        }
        else if( fieldValue != null && !fieldValue.isEmpty()) {

            if (fieldName.equals("CustomerId")) {
                if (!fieldValue.chars().allMatch(Character::isDigit)) {
                    tempModel.addObject("messageType", "error");
                    tempModel.addObject("appMessage", "Error!!!, Invalid input value!");
                    tempModel.setViewName("/customer/searchCustomer");
                    tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
                    return tempModel;
                }
                Customer customer = customerService.findByCustomerId(Long.parseLong(fieldValue));
                if (customer != null) {
                    customerList = new ArrayList<>();
                    customerList.add(customer);
                }
            } else if (fieldName.equals("LastName")) {
                customerList = customerService.findByLastName(fieldValue);
            } else if (fieldName.equals("EmailAddress")) {
                customerList = customerService.findByEmailAddress(fieldValue);
            } else if (fieldName.equals("PhoneNumber")) {
                customerList = customerService.findByPhoneNumber(fieldValue);
            }
        }

        if (customerList.size() > 0) { // success
            tempModel.addObject("messageType", "success");
            tempModel.addObject("appMessage", customerList);
            tempModel.setViewName("/customer/searchCustomer");
            tempModel.setStatus(HttpStatus.OK);
        }
        else { // error
            tempModel.addObject("messageType", "error");
            tempModel.addObject("appMessage", "Error!!!, could not  find Customer with given information!");
            tempModel.setViewName("/customer/searchCustomer");
            tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }
        return tempModel;
    }
    //==================================================================================================================

}
