package com.soshiant.controller.employee;


import com.soshiant.model.employee.Employee;
import com.soshiant.service.employee.EmployeeService;
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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //============================== Url : http://localhost:8080/springmvc/showRegisterEmployee=============================
    @RequestMapping(value = "/showRegisterEmployee",method = RequestMethod.GET)
    public ModelAndView showRegisterEmployeeForm()  {

        ModelAndView model = new ModelAndView("/employee/registerEmployee");
        return model;
    }
    //============================== Url : http://localhost:8080/springmvc/registerEmployee=================================
    @RequestMapping(value = "/registerEmployee",method = RequestMethod.POST)
    public ModelAndView registerNewEmployee(@RequestParam(value= "firstName",required = true) String firstName,
                                     @RequestParam(value= "lastName",required = true) String lastName,
                                     @RequestParam(value= "emailAddress",required = true) String emailAddress,
                                     @RequestParam(value= "phoneNumber",required = true) String phoneNumber) throws Exception {

        ModelAndView tempModel = new ModelAndView();
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmailAddress(emailAddress);
        employee.setPhoneNumber(phoneNumber);


        Employee resultData = employeeService.addNewEmployee(employee);
        if (resultData != null) { // success
            tempModel.addObject("messageType", "success");
            tempModel.addObject("appMessage", "Employee Registered Successfully with employee Id : " + resultData.getEmployeeId());
            tempModel.setViewName("appMessages");
            tempModel.setStatus(HttpStatus.OK);
        }
        else { // error
            tempModel.addObject("messageType", "error");
            tempModel.addObject("appMessage", "Error!!!, could not  Register Employee info ");
            tempModel.setViewName("appMessages");
            tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }
        return tempModel;
    }
    //============================== Url : http://localhost:8080/springmvc/showRegisterEmployee=========================
    @RequestMapping(value = "/showSearchEmployee",method = RequestMethod.GET)
    public ModelAndView showSearchEmployee()  {

        ModelAndView model = new ModelAndView("/employee/searchEmployee");
        model.addObject("messageType", "");
        model.addObject("appMessage", "");

        return model;
    }
    //============================== Url : http://localhost:8080/springmvc/registerEmployee=============================
    @RequestMapping(value = "/searchEmployee",method = RequestMethod.POST)
    public ModelAndView showSearchEmployeeResult(@RequestParam(value= "fieldName",required = true) String fieldName,
                                                 @RequestParam(value= "fieldValue",required = true) String fieldValue)
                                                 throws Exception {

        ModelAndView tempModel = new ModelAndView();

        List<Employee> employeeList = null;

        if( fieldName.equals("AllEmployees") ) {
            employeeList = employeeService.getAllEmployees();
        }
        else if( fieldValue != null && !fieldValue.isEmpty()) {

            if (fieldName.equals("EmployeeId")) {
                if (!fieldValue.chars().allMatch(Character::isDigit)) {
                    tempModel.addObject("messageType", "error");
                    tempModel.addObject("appMessage", "Error!!!, Invalid input value!");
                    tempModel.setViewName("/employee/searchEmployee");
                    tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
                    return tempModel;
                }
                Employee employee = employeeService.findById(Long.parseLong(fieldValue));
                if (employee != null) {
                    employeeList = new ArrayList<>();
                    employeeList.add(employee);
                }
            }
            else if (fieldName.equals("FirstName")) {
                employeeList = employeeService.findByFirstName(fieldValue);
            }
            else if (fieldName.equals("LastName")) {
                employeeList = employeeService.findByLastName(fieldValue);
            }
        }
        if (employeeList != null && employeeList.size() > 0) { // success
            tempModel.addObject("messageType", "success");
            tempModel.addObject("appMessage", employeeList);
            tempModel.setViewName("/employee/searchEmployee");
            tempModel.setStatus(HttpStatus.OK);
        }
        else { // error
            tempModel.addObject("messageType", "error");
            tempModel.addObject("appMessage", "Error!!!, could not  find Employee with given information!");
            tempModel.setViewName("/employee/searchEmployee");
            tempModel.setStatus(HttpStatus.NOT_ACCEPTABLE);
        }
        return tempModel;
    }
    //==================================================================================================================

}
