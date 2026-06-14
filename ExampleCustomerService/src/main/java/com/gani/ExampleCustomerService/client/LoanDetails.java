package com.gani.ExampleCustomerService.client;

import com.gani.ExampleCustomerService.dto.Customer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("EXAMPLELOANSERVICE")
public interface LoanDetails {
    @GetMapping("/cust/{custId}")
    public ResponseEntity<List<Customer>> getCust(@PathVariable Long custId);
}
