package com.kasun.hr_system.repository;

import com.kasun.hr_system.domain.BankDetails;
import org.springframework.data.repository.CrudRepository;

public interface BankDetailsRepo extends CrudRepository<BankDetails, Integer> {
}
