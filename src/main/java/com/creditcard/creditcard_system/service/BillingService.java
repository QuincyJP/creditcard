package com.creditcard.creditcard_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.creditcard_system.model.*;
import com.creditcard.creditcard_system.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private BillingStatementRepository billingStatementRepository;

    public BillingStatement generateStatement(Long cardId) {

        CreditCard card = creditCardRepository.findById(cardId).orElseThrow();

        List<Transaction> transactions = transactionRepository.findByCreditCard(card);

        double total = 0;

        for(Transaction t : transactions){
            total += t.getAmount();
        }

        double interest = total * 0.03; // 3% interest
        double lateFee = 500; // fixed late fee

        BillingStatement statement = new BillingStatement();
        statement.setCreditCard(card);
        statement.setTotalAmount(total);
        statement.setInterestAmount(interest);
        statement.setLateFee(lateFee);
        statement.setStatementDate(LocalDate.now());
        statement.setDueDate(LocalDate.now().plusDays(15));

        return billingStatementRepository.save(statement);
    }
}