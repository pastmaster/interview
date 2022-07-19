package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.service.CurrencyNameService;

@RestController
public class CurrencyNameMaintain {

	@Autowired
	private CurrencyNameService currencyNameService;
	
	@RequestMapping("/insertCurrencyName")
	public void insert(InsertCurrencyNameRequestDTO request) throws Exception {
		
	}
}
