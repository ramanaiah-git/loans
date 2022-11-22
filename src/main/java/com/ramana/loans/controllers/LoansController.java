package com.ramana.loans.controllers;

import com.ramana.loans.model.Customer;
import com.ramana.loans.model.Loans;
import com.ramana.loans.repositories.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository repository;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer){
        List<Loans> loans = repository.findByCustomerIdOrderByStartDate(customer.getCustomerId());
        return loans;
    }

}
