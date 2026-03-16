package com.creditcard.creditcard_system.model;

import jakarta.persistence.*;

@Entity
public class InterestLateCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String type;

    @ManyToOne
    @JoinColumn(name = "billingstatement_id")
    private BillingStatement billingStatement;

    public InterestLateCharge() {}

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BillingStatement getBillingStatement() {
        return billingStatement;
    }

    public void setBillingStatement(BillingStatement billingStatement) {
        this.billingStatement = billingStatement;
    }
}