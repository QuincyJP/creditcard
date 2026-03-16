package com.creditcard.creditcard_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creditcard.creditcard_system.model.InterestLateCharge;

public interface InterestLateChargeRepository extends JpaRepository<InterestLateCharge, Long> {
}