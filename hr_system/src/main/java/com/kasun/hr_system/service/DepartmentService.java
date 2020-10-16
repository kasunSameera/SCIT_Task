package com.kasun.hr_system.service;

import com.kasun.hr_system.domain.Department;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public String createDepartment(Department department){
        departmentRepo.save(department);
        return "successfully Created";
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public String updateDepartment(Department department, int departmentCode) throws ResourceNotFoundException {

        Department departmentOld = departmentRepo.findById(departmentCode).orElseThrow(()-> new ResourceNotFoundException("Department Not Found"));
        departmentOld.setDepartmentCode(department.getDepartmentCode());
        departmentOld.setName(department.getName());
        departmentOld.setPhoneNumber(department.getPhoneNumber());
        departmentRepo.save(departmentOld);
        return "successfully Updated";
    }

    public String deleteDepartment( int departmentCode) throws ResourceNotFoundException {

        departmentRepo.findById(departmentCode).orElseThrow(()-> new ResourceNotFoundException("Department Not Found"));
        departmentRepo.deleteById(departmentCode);
        return "successfully Deleted";
    }
}
