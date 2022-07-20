package com.api.service;

import java.util.List;

import com.api.dto.currencyname.CurrencyNameDTO;
import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.dto.currencyname.UpdateCurrencyNameRequestDTO;

public interface CurrencyNameService {

	public void insert(InsertCurrencyNameRequestDTO dto) throws Exception;
 
    public List<CurrencyNameDTO> fetchCurrencyNameList() throws Exception;
 
    public void updateCurrencyName(UpdateCurrencyNameRequestDTO dto) throws Exception;
 
    public void deleteCurrencyNameById(String currencyNameId) throws Exception;
    
}
