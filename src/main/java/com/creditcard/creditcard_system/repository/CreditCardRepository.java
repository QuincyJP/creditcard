package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
