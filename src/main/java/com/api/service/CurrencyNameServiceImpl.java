package com.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.dto.currencyname.CurrencyNameDTO;
import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.dto.currencyname.QueryCurrencyNameResponseDTO;
import com.api.dto.currencyname.UpdateCurrencyNameRequestDTO;
import com.api.entity.CurrencyName;
import com.api.exception.APException;
import com.api.repository.CurrencyNameRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CurrencyNameServiceImpl implements CurrencyNameService {

	@Autowired
	private CurrencyNameRepository currencyNameRepository;
	
	@Override
	public void insert(InsertCurrencyNameRequestDTO dto) throws Exception {
		Optional<CurrencyName> queryOptional = currencyNameRepository.findById(dto.getCode());
		if (queryOptional.isEmpty()) {
			CurrencyName entity = new CurrencyName();
			entity.setCode(dto.getCode());
			entity.setName(dto.getName());
			currencyNameRepository.save(entity);
		} else {
			throw new APException("Code [" + dto.getCode() + "] already exist.");
		}
	}

	@Override
	public List<CurrencyNameDTO> fetchCurrencyNameList() throws Exception {
		List<CurrencyName> queryResult = currencyNameRepository.findAll();
		List<CurrencyNameDTO> bpi = new ArrayList<>(queryResult.size());
		for (CurrencyName entity : queryResult) {
			CurrencyNameDTO dto = new CurrencyNameDTO();
			dto.setCode(entity.getCode());
			dto.setName(entity.getName());
			bpi.add(dto);
		}
		return bpi;
	}

	@Override
	public void updateCurrencyName(UpdateCurrencyNameRequestDTO dto) throws Exception {
		CurrencyName entity = new CurrencyName();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		currencyNameRepository.save(entity);
	}

	@Override
	public void deleteCurrencyNameById(String currencyNameId) throws Exception {
		currencyNameRepository.deleteById(currencyNameId);
	}
	
}
