package com.kasun.hr_system.repository;

import com.kasun.hr_system.domain.Salary;
import org.springframework.data.repository.CrudRepository;

public interface SalaryRepo extends CrudRepository<Salary, Integer> {
}
