package com.kasun.hr_system.controller;

import com.kasun.hr_system.domain.BankDetails;
import com.kasun.hr_system.exception.ResourceNotFoundException;
import com.kasun.hr_system.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankDetailsController {

    @Autowired
    private BankDetailsService bankDetailsService;

    @RequestMapping(method = RequestMethod.POST, value = "/bankDetails/{employeeId}")
    public String createBankDetail(@RequestBody BankDetails bankDetails, @PathVariable int employeeId) {
        String message = bankDetailsService.createBankDetail(bankDetails,employeeId);
        return message;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bankDetails")
        public List<BankDetails> getAllBankDetails() {
        Iterable<BankDetails> bankDetails = bankDetailsService.getAllBankDetails();
        return (List<BankDetails>) bankDetails;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/bankDetails/{id}")
    public String updateBankDetail(@RequestBody BankDetails bankDetails, @PathVariable int id) throws ResourceNotFoundException {
        String message = bankDetailsService.updateBankDetail(bankDetails,id);
        return message;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/bankDetails/{id}")
    public String deleteBankDetail(@PathVariable int id) throws ResourceNotFoundException {
        String message = bankDetailsService.deleteBankDetail(id);
        return message;
    }
}
