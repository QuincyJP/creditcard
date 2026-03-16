package com.creditcard.creditcard_system.controller;

import com.creditcard.creditcard_system.model.CreditCard;
import com.creditcard.creditcard_system.repository.CreditCardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping
    public CreditCard createCard(@RequestBody CreditCard card) {
        return creditCardRepository.save(card);
    }

    @GetMapping
    public List<CreditCard> getAllCards() {
        return creditCardRepository.findAll();
    }
}