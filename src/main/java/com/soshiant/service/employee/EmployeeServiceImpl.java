package com.soshiant.service.employee;


import com.soshiant.model.employee.Employee;
import com.soshiant.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {



    @Autowired
    private EmployeeRepository employeeRepository;

    //==================================================================================================================
    @Transactional
    public Employee addNewEmployee(Employee employee) {

        try {
            Date date = new Date();
            employee.setCreateDate(date);
            Employee savedEmployee = employeeRepository.saveEmployee(employee);
            System.out.print("Id : " + savedEmployee.getEmployeeId());
            return savedEmployee;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public Employee findById(long employeeId) {

        try {
            Employee employee = employeeRepository.getEmployeeById(employeeId);
            return employee;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Employee> findByFirstName(String firstName) {

        try {
            List<Employee> employeeList = employeeRepository.getEmployeesByFirstName(firstName);
            return employeeList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Employee> findByLastName(String lastName) {

        try {
            List<Employee> employeeList = employeeRepository.getEmployeesByLastName(lastName);
            return employeeList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Employee> getAllEmployees() {

        try {
            List<Employee> employeeList = employeeRepository.getAllEmployees();
            return employeeList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //======================================================================================================================
}

