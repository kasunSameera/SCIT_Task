package com.kasun.hr_system.domain;

import javax.persistence.*;

@Entity
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float workingHours;

    private Double rate;

    private Double salary;

    private Integer year;

    private Integer month;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false)
    private Employee employee;

    public Salary(Float workingHours, Double rate, Double salary, Integer year, Integer month) {
        this.workingHours = workingHours;
        this.rate = rate;
        this.salary = salary;
        this.year = year;
        this.month = month;
    }

    public Salary() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Float workingHours) {
        this.workingHours = workingHours;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
