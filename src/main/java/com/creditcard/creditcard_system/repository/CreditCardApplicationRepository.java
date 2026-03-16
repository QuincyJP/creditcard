package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.CreditCardApplication;

public interface CreditCardApplicationRepository 
        extends JpaRepository<CreditCardApplication, Long> {
}