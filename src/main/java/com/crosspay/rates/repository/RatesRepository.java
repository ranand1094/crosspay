package com.crosspay.rates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crosspay.rates.entity.InterBankRates;

@Repository
public interface RatesRepository extends JpaRepository<InterBankRates,String> {

}
