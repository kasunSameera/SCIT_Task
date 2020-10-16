package com.kasun.hr_system.service;

import com.kasun.hr_system.domain.Employee;
import com.kasun.hr_system.domain.Salary;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.repository.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepo salaryRepo;

    public String createSalary(Salary salary, int employeeId) {

        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        salary.setEmployee(employee);
        salaryRepo.save(salary);
        return "successfully Created";
    }

    public Iterable<Salary> getAllSalaries() {
        return salaryRepo.findAll();
    }

    public String updateSalary(Salary salary, int id) throws ResourceNotFoundException {

        Salary salaryOld = salaryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Salary Not Found"));
        salaryOld.setWorkingHours(salary.getWorkingHours());
        salaryOld.setRate(salary.getRate());
        salaryOld.setSalary(salary.getSalary());
        salaryOld.setMonth(salary.getMonth());
        salaryOld.setYear(salary.getYear());
        salaryRepo.save(salaryOld);
        return "successfully Updated";
    }

    public String deleteSalary(int id) throws ResourceNotFoundException {

        salaryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Salary Not Found"));
        salaryRepo.deleteById(id);
        return "successfully Deleted";
    }
}
