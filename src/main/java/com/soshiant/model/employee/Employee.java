package com.soshiant.model.employee;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "EMPLOYEE")

@NamedNativeQueries({
        @NamedNativeQuery(name  = "getAllEmployees",
                          query = "SELECT EmployeeId, FirstName, LastName, EmailAddress, PhoneNumber, CreateDate FROM employee",
                          resultClass=Employee.class
        ),
        @NamedNativeQuery(name  = "getAllEmployeesByFirstName",
                          query = "SELECT EmployeeId, FirstName, LastName, EmailAddress, PhoneNumber, CreateDate FROM employee WHERE FirstName=?",
                          resultClass = Employee.class
        )
})
public class Employee implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeSequence")
    @SequenceGenerator(name = "EmployeeSequence", sequenceName = "employeeSeq", initialValue = 1000, allocationSize = 1 )
    @Column(name = "EmployeeId")
    private Long employeeId;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;


    public Employee() {}


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
