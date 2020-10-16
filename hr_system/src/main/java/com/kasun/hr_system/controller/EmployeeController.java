package com.kasun.hr_system.controller;

import com.kasun.hr_system.domain.Employee;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST, value = "/employee")
    public String createEmployee(@RequestBody Employee employee) {
        String message = employeeService.createEmployee(employee);
        return message;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public List<Employee> getAllEmployees() {
        Iterable<Employee> employees = employeeService.getAllEmployees();
        return (List<Employee>) employees;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) throws ResourceNotFoundException {
        String message = employeeService.updateEmployee(employee,id);
        return message;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public String deleteEmployee(@PathVariable int id) throws ResourceNotFoundException {
        String message = employeeService.deleteEmployee(id);
        return message;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee/assignDepartment/{id}/{departmentCode}")
    public String assignDepartment(@PathVariable int id, @PathVariable int departmentCode) throws ResourceNotFoundException {
        String message = employeeService.assignDepartment(id,departmentCode);
        return message;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/employee/uploadImage/{id}")
    public String uploadImage(@PathVariable int id, @RequestParam("file")MultipartFile file) throws ResourceNotFoundException, IOException {
        String message = employeeService.uploadImage(id,file);
        return message;
    }
}
