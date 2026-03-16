package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.BillingStatement;

public interface BillingStatementRepository extends JpaRepository<BillingStatement, Long> {
}