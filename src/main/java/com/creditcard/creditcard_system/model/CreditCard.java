package com.creditcard.creditcard_system.model;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private double limitAmount;
    private double availableLimit;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public CreditCard() {}

    public Long getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(double availableLimit) {
        this.availableLimit = availableLimit;
    }
}
