package com.kasun.hr_system.service;

import com.kasun.hr_system.domain.BankDetails;
import com.kasun.hr_system.domain.Employee;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.repository.BankDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsService {

    @Autowired
    private BankDetailsRepo bankDetailsRepo;


    public String createBankDetail(BankDetails bankDetails, int employeeId) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setBankDetails(bankDetails);
        bankDetails.setEmployee(employee);
        bankDetailsRepo.save(bankDetails);
        return "successfully Created";
    }

    public Iterable<BankDetails> getAllBankDetails() {
        return bankDetailsRepo.findAll();
    }


    public String updateBankDetail(BankDetails bankDetails, int id) throws ResourceNotFoundException {
       BankDetails bankDetailsOld = bankDetailsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bank Details Not Found"));
        bankDetailsOld.setBankCode(bankDetails.getBankCode());
        bankDetailsOld.setBankName(bankDetails.getBankName());
        bankDetailsOld.setBranchName(bankDetails.getBranchName());
        bankDetailsOld.setAccountNumber(bankDetails.getAccountNumber());
        bankDetailsRepo.save(bankDetailsOld);
        return "successfully Updated";
    }

    public String deleteBankDetail(int id) throws ResourceNotFoundException {

        bankDetailsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bank Details Not Found"));
        bankDetailsRepo.deleteById(id);
        return "successfully Deleted";
    }
}
