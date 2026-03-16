package com.creditcard.creditcard_system.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class BillingStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalAmount;

    private double interestAmount;

    private double lateFee;

    private LocalDate statementDate;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "creditcard_id")
    private CreditCard creditCard;

    public BillingStatement() {}

    public Long getId() {
        return id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getInterestAmount() {
    return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public LocalDate getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(LocalDate statementDate) {
        this.statementDate = statementDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}