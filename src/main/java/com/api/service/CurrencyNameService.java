package com.api.service;

import org.springframework.stereotype.Service;

import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.entity.CurrencyName;

@Service
public class CurrencyNameService {

	
	
	public void insert(InsertCurrencyNameRequestDTO dto) throws Exception {
		CurrencyName entity = new CurrencyName();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
	}
	
}
