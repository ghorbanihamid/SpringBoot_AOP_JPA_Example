package com.soshiant.repository.employee;


import com.soshiant.model.employee.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    //==================================================================================================================
    public Employee saveEmployee(Employee employee){

        try{
            em.persist(employee);
            em.flush();
            return employee;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    //==================================================================================================================
    public Employee getEmployeeById(long id) {

        Employee employee = null;
        try{
            employee = em.find(Employee.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }
    //==================================================================================================================
    public Employee getEmployeeByObject(Employee emloyee) {

        Employee employee = null;
        try{
            employee = em.find(Employee.class, employee);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    //==================================================================================================================
    public List<Employee> getEmployeesByFirstName(String firstName){

        try{
            List<Employee> employeeList = em.createNamedQuery("getAllEmployeesByFirstName", Employee.class).setParameter(0, firstName).getResultList();
            return employeeList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Employee> getEmployeesByLastName(String lastName){

        try{
            return em.createQuery("SELECT e FROM Employee e WHERE e.lastName = '" + lastName + "'", Employee.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================
    public List<Employee> getAllEmployees(){

        try{
            List<Employee> employeeList = em.createNamedQuery("getAllEmployees", Employee.class).getResultList();
            return employeeList;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //==================================================================================================================

}

