package com.gani.ExampleCustomerService.repo;

import com.gani.ExampleCustomerService.dto.FullDetails;
import com.gani.ExampleCustomerService.entity.AccountDetails;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<AccountDetails,Long> {

}
