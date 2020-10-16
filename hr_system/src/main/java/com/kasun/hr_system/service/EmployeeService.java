package com.kasun.hr_system.service;

import com.kasun.hr_system.domain.Department;
import com.kasun.hr_system.domain.Employee;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public String createEmployee(Employee employee){

        if(employee.getFirstName().isEmpty()){
            return "First Name is Empty";
        }
        if(employee.getLastName().isEmpty()){
            return  "Last Name is Empty";
        }
        employeeRepo.save(employee);
        return "successfully Created";
    }

    public Iterable<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public String updateEmployee(Employee employee, int id) throws ResourceNotFoundException {

        Employee employeeOld = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found"));
        employeeOld.setFirstName(employee.getFirstName());
        employeeOld.setLastName(employee.getLastName());
        employeeOld.setAddress(employee.getAddress());
        employeeRepo.save(employeeOld);
        return "successfully Updated";
    }

    public String deleteEmployee( int id) throws ResourceNotFoundException {

        employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found"));
        employeeRepo.deleteById(id);
        return "successfully Deleted";
    }

    public String assignDepartment(int id, int departmentCode) throws ResourceNotFoundException {
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found"));
        Set<Department> department = employee.getWorksOn();
        Department departmentNew = new Department();
        departmentNew.setDepartmentCode(departmentCode);
        department.add(departmentNew);
        employee.setWorksOn(department);
        employeeRepo.save(employee);
        return "successfully Assigned";
    }

    public String uploadImage(int id, MultipartFile file) throws ResourceNotFoundException, IOException {
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found"));
        try{
            byte[] imageData = file.getBytes();
            employee.setImageData(imageData);
            employeeRepo.save(employee);
            return "successfully Uploaded the Image";
        }catch (Exception e){
            return e.toString();
        }

    }
}
