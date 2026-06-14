package com.gani.ExampleLoanService.repo;

import com.gani.ExampleLoanService.entity.Customer;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Customer,Long> {

    @Nullable List<Customer> findByCustomerId(Long custId);
}
