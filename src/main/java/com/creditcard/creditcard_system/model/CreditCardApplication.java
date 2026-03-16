package com.creditcard.creditcard_system.model;

import jakarta.persistence.*;

@Entity
public class CreditCardApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;

    private String email;

    private int cibilScore;

    private String status;

    public CreditCardApplication(){}

    public Long getId(){ return id; }

    public String getApplicantName(){ return applicantName; }

    public void setApplicantName(String applicantName){
        this.applicantName = applicantName;
    }

    public String getEmail(){ return email; }

    public void setEmail(String email){
        this.email = email;
    }

    public int getCibilScore(){ return cibilScore; }

    public void setCibilScore(int cibilScore){
        this.cibilScore = cibilScore;
    }

    public String getStatus(){ return status; }

    public void setStatus(String status){
        this.status = status;
    }
}