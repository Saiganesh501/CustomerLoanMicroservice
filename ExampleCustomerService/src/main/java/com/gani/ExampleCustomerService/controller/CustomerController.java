package com.gani.ExampleCustomerService.controller;

import com.gani.ExampleCustomerService.dto.FullDetails;
import com.gani.ExampleCustomerService.entity.AccountDetails;
import com.gani.ExampleCustomerService.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Just Added Comment
//
//
@RestController
public class CustomerController{

    CustomerService service;
    public CustomerController(CustomerService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<AccountDetails>> accountDetails(){
        return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/save")
    public ResponseEntity<AccountDetails> save(@RequestBody AccountDetails accountDetails){
        return ResponseEntity.ok(service.save(accountDetails));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDetails> update(@PathVariable Long id , @RequestBody AccountDetails accountDetails){
        return ResponseEntity.ok(service.update(id,accountDetails));
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<AccountDetails> patch(@PathVariable Long id ,@RequestBody AccountDetails accountDetails){
        return  ResponseEntity.ok(service.getPatch(id,accountDetails));
    }

    @GetMapping("/fulldetails/{id}")
    public ResponseEntity<FullDetails> getFullDetailsById(@PathVariable Long id){
        return ResponseEntity.ok(service.findFullDetailsById(id));
    }

}