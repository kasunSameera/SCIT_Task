package com.kasun.hr_system.controller;

import com.kasun.hr_system.domain.Salary;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(method = RequestMethod.POST, value = "/salary/{employeeId}")
    public String createSalary(@RequestBody Salary salary, @PathVariable int employeeId) {
        String message = salaryService.createSalary(salary,employeeId);
        return message;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salary")
    public List<Salary> getAllSalaries() {
        Iterable<Salary> salaries = salaryService.getAllSalaries();
        return (List<Salary>) salaries ;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/salary/{id}")
    public String updateSalary(@RequestBody Salary salary, @PathVariable int id) throws ResourceNotFoundException {
        String message = salaryService.updateSalary(salary,id);
        return message;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/salary/{id}")
    public String deleteSalary(@PathVariable int id) throws ResourceNotFoundException {
        String message = salaryService.deleteSalary(id);
        return message;
    }
}
