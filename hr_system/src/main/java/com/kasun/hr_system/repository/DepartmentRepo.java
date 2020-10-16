package com.kasun.hr_system.repository;

import com.kasun.hr_system.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {
}
