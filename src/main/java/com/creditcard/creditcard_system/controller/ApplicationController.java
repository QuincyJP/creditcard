package com.creditcard.creditcard_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.creditcard.creditcard_system.model.CreditCard;
import com.creditcard.creditcard_system.model.CreditCardApplication;
import com.creditcard.creditcard_system.model.Customer;
import com.creditcard.creditcard_system.repository.CreditCardApplicationRepository;
import com.creditcard.creditcard_system.repository.CreditCardRepository;
import com.creditcard.creditcard_system.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private CreditCardApplicationRepository repo;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public CreditCardApplication apply(@RequestBody CreditCardApplication app) {

        app.setStatus("PENDING");

        return repo.save(app);
    }

    @GetMapping
    public List<CreditCardApplication> getAllApplications(){
        return repo.findAll();
    }

    @PostMapping("/approve/{id}")
    public CreditCardApplication approveApplication(@PathVariable Long id){

        CreditCardApplication app = repo.findById(id).orElseThrow();

        if(app.getCibilScore() >= 700){
            app.setStatus("APPROVED");

            Customer customer = new Customer();
            customer.setName(app.getApplicantName());
            customer.setEmail(app.getEmail());

            customerRepository.save(customer);

            CreditCard card = new CreditCard();
            card.setCardNumber("CARD"+System.currentTimeMillis());
            card.setLimitAmount(50000);
            card.setAvailableLimit(50000);
            card.setCustomer(customer);

            creditCardRepository.save(card);
        }else{
            app.setStatus("REJECTED");
        }

        return repo.save(app);
    }
}