package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.Transaction;
import com.creditcard.creditcard_system.model.CreditCard;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCreditCard(CreditCard creditCard);
}