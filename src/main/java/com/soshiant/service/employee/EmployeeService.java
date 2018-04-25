package com.soshiant.service.employee;


import com.soshiant.model.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeeService {

    public Employee addNewEmployee(Employee employee);

    public Employee findById(long employeeId);

    public List<Employee> findByFirstName(String firstName);

    public List<Employee> findByLastName(String lastName);

    public List<Employee> getAllEmployees();

}
