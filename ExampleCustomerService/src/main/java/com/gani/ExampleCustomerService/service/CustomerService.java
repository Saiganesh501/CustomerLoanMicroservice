package com.gani.ExampleCustomerService.service;

import com.gani.ExampleCustomerService.client.LoanDetails;
import com.gani.ExampleCustomerService.dto.Customer;
import com.gani.ExampleCustomerService.dto.FullDetails;
import com.gani.ExampleCustomerService.entity.AccountDetails;
import com.gani.ExampleCustomerService.repo.CustomerRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    LoanDetails loanDetails;
    CustomerRepo repo;
    public CustomerService(CustomerRepo repo, LoanDetails loanDetails){this.repo=repo; this.loanDetails=loanDetails;}
    public @Nullable List<AccountDetails> findAll() {
        return repo.findAll();
    }

    public @Nullable FullDetails findFullDetailsById(Long id) {
        AccountDetails details = repo.findById(id).orElse(new AccountDetails());
        List<Customer> customers = loanDetails.getCust(id).getBody();
        return new FullDetails(details,customers);

    }

    public @Nullable AccountDetails save(AccountDetails accountDetails) {
        return repo.save(accountDetails);
    }

    public @Nullable AccountDetails update(Long id, AccountDetails accountDetails) {
        AccountDetails details = repo.findById(id).orElse(new AccountDetails());
            details.setEmail(accountDetails.getEmail());
            details.setName(accountDetails.getName());
            details.setPhone(accountDetails.getPhone());

            return repo.save(details);

    }

    public @Nullable AccountDetails getPatch(Long id, AccountDetails accountDetails) {
        AccountDetails details = repo.findById(id).get();
        if(accountDetails.getName()!= null)
            details.setName(accountDetails.getName());
        if(accountDetails.getEmail()!= null)
            details.setEmail(accountDetails.getEmail());
        if(accountDetails.getPhone()!= null)
            details.setPhone(accountDetails.getPhone());

        return repo.save(details);

    }


}
