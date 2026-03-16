package com.creditcard.creditcard_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.creditcard.creditcard_system.model.BillingStatement;
import com.creditcard.creditcard_system.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/generate/{cardId}")
    public BillingStatement generateStatement(@PathVariable Long cardId){
        return billingService.generateStatement(cardId);
    }
}