package com.kasun.hr_system.controller;

import com.kasun.hr_system.domain.Department;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(method = RequestMethod.POST, value = "/department")
    public String createDepartment(@RequestBody Department department) {
        String message = departmentService.createDepartment(department);
        return message;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/department")
    public List<Department> getAllDepartments() {
        Iterable<Department> employees = departmentService.getAllDepartments();
        return (List<Department>) employees;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/department/{departmentCode}")
    public String updateDepartment(@RequestBody Department department, @PathVariable int departmentCode) throws ResourceNotFoundException {
        String message = departmentService.updateDepartment(department,departmentCode);
        return message;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/department/{departmentCode}")
    public String deleteDepartment(@PathVariable int departmentCode) throws ResourceNotFoundException {
        String message = departmentService.deleteDepartment(departmentCode);
        return message;
    }
}
