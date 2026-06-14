package com.gani.ExampleCustomerService.dto;

import com.gani.ExampleCustomerService.entity.AccountDetails;

import java.util.List;

public class FullDetails {
    private AccountDetails accountDetails;
    private List<Customer> customer;

    public FullDetails(AccountDetails accountDetails, List<Customer> customer) {
        this.accountDetails = accountDetails;
        this.customer = customer;
    }
    public FullDetails(){}

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "FullDetails{" +
                "accountDetails=" + accountDetails +
                ", customer=" + customer +
                '}';
    }
}
