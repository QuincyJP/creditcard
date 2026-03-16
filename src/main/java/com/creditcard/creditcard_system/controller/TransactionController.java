package com.creditcard.creditcard_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.creditcard.creditcard_system.model.*;
import com.creditcard.creditcard_system.repository.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping
    public Transaction makeTransaction(@RequestBody Transaction transaction){

        CreditCard card = creditCardRepository
                .findById(transaction.getCreditCard().getId())
                .orElseThrow();

        if(transaction.getAmount() > card.getAvailableLimit()){
            throw new RuntimeException("Credit limit exceeded");
        }

        card.setAvailableLimit(
                card.getAvailableLimit() - transaction.getAmount()
        );

        creditCardRepository.save(card);

        transaction.setTransactionDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

}