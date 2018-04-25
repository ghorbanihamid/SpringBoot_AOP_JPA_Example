package com.soshiant.repository.employee;


import com.soshiant.model.employee.Employee;

import java.util.List;


public interface EmployeeRepository {

    public Employee saveEmployee(Employee emloyee);

    public Employee getEmployeeById(long id);

    public Employee getEmployeeByObject(Employee emloyee);

    public List<Employee> getEmployeesByFirstName(String firstName);

    public List<Employee> getEmployeesByLastName(String lastName);

    public List<Employee> getAllEmployees();

}

