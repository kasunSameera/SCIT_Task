package com.kasun.hr_system.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, name = "employee_id")
    private Integer employeeId;

    private String firstName;

    private String lastName;

    private String address;

    @Lob
    private byte[] imageData;

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private BankDetails bankDetails;

    @ManyToMany
    @JoinTable(
            name = "works_on",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
     private Set<Department> worksOn;

    @OneToMany(mappedBy="employee")
    private Set<Salary> salary;

    public Set<Department> getWorksOn() {
        return worksOn;
    }

    public void setWorksOn(Set<Department> worksOn) {
        this.worksOn = worksOn;
    }

    public Set<Salary> getSalary() {
        return salary;
    }

    public void setSalary(Set<Salary> salary) {
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Employee(String firstName, String lastName, String address, byte[] imageData) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.imageData = imageData;
    }

    public Employee() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }
}
