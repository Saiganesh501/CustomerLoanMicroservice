package com.gani.ExampleLoanService.service;

import com.gani.ExampleLoanService.entity.Customer;
import com.gani.ExampleLoanService.repo.LoanRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanService {
    LoanRepo repo ;
    @Autowired
    public LoanService(LoanRepo repo){
        this.repo=repo;
    }
    public List<Customer> findAll() {
        return repo.findAll();
    }

    public  Customer findById(Long id) {
        return repo.findById(id).orElse(new Customer());
    }

    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    public @Nullable Customer update(long id,Customer customer) {
        Customer cust =  repo.findById(id).orElse(new Customer());
        if (cust==null || cust.getLoanId()==null){
            throw new RuntimeException("Object Not Found"+ cust);

        }
         cust.setCustomerId(customer.getCustomerId());
         cust.setLoanAmount(customer.getLoanAmount());
         cust.setLoanType(cust.getLoanType());
         cust.setLoanStatus(customer.getLoanStatus());

         return repo.save(cust);

    }

    public @Nullable List<Customer> findbyCustId(Long custId) {
        return repo.findByCustomerId(custId);
    }
}
