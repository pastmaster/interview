package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.CurrencyName;

@Repository
public interface CurrencyNameRepository extends JpaRepository<CurrencyName, String> {
	
}
