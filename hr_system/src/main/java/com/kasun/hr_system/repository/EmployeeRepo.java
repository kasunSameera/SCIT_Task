package com.kasun.hr_system.repository;

import com.kasun.hr_system.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
}
