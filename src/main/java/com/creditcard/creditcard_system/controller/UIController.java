package com.creditcard.creditcard_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UIController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/apply")
    public String applyPage(){
        return "apply";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/transactionsPage")
    public String transactionsPage(){
        return "transactions";
    }

    @GetMapping("/billingPage")
    public String billingPage(){
        return "billing";
    }

    @GetMapping("/architecture")
    public String architecturePage(){
        return "architecture";
    }
}