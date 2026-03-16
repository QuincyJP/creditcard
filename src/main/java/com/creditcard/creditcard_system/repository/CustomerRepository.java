package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}