package com.kasun.hr_system.domain;

import javax.persistence.*;

@Entity
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String bankCode;

    private String bankName;

    private String branchName;

    @Column(unique = true)
    private Long accountNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Employee employee;

    public BankDetails(String bankCode, String bankName, String branchName, Long accountNumber) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.branchName = branchName;
        this.accountNumber = accountNumber;
    }

    public BankDetails() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
