package com.kasun.hr_system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Department {

    @Id
    @Column(unique = true, name = "department_id")
    private Integer departmentCode;

    private String name;

    private long phoneNumber;

    @ManyToMany(mappedBy = "worksOn")
    Set<Employee> works;

    public void setDepartmentCode(Integer departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Set<Employee> getWorks() {
        return works;
    }

    public void setWorks(Set<Employee> works) {
        this.works = works;
    }

    public Department(int departmentCode, String name, long phoneNumber) {
        this.departmentCode = departmentCode;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Department() {

    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
