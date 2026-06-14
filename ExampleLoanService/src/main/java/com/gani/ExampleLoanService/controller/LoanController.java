package com.gani.ExampleLoanService.controller;

import com.gani.ExampleLoanService.entity.Customer;
import com.gani.ExampleLoanService.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LoanController {

    LoanService service;
    @Autowired
    public LoanController(LoanService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> get(){
        return ResponseEntity.ok( service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getId(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(service.save(customer));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable long id,@RequestBody Customer customer){

        return ResponseEntity.ok(service.update(id,customer));
    }
    @GetMapping("/cust/{custId}")
    public ResponseEntity<List<Customer>> getCust(@PathVariable Long custId){

        return ResponseEntity.ok( service.findbyCustId(custId));
    }

}

