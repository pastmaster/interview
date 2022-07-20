package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.currencyname.DeleteCurrencyNameRequestDTO;
import com.api.dto.currencyname.DeleteCurrencyNameResponseDTO;
import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.dto.currencyname.InsertCurrencyNameResponseDTO;
import com.api.dto.currencyname.QueryCurrencyNameResponseDTO;
import com.api.dto.currencyname.UpdateCurrencyNameRequestDTO;
import com.api.dto.currencyname.UpdateCurrencyNameResponseDTO;
import com.api.exception.APException;
import com.api.service.CurrencyNameService;
import com.api.util.StackTraceUtil;

@RestController
public class CurrencyNameController {

	@Autowired
	private CurrencyNameService currencyNameService;

	private static final String SUCCESS = "Success";
	private static final String FAIL = "Fail";
	
	@RequestMapping("/insertCurrencyName")
	public InsertCurrencyNameResponseDTO insert(@RequestBody InsertCurrencyNameRequestDTO dto) throws Exception {
		InsertCurrencyNameResponseDTO ret = new InsertCurrencyNameResponseDTO();
		ret.setRequest(dto);
		try {
			currencyNameService.insert(dto);
			ret.setResult(SUCCESS);
			ret.setMessage("Insert Success");
		} catch(APException e) {
			ret.setResult(FAIL);
			ret.setMessage(e.getMessage());
		} catch(Exception e) {
			ret.setResult(FAIL);
			ret.setMessage(StackTraceUtil.parse(e));
		}
		return ret;
	}
	
	@RequestMapping("/queryCurrencyName")
	public QueryCurrencyNameResponseDTO query() throws Exception {
		QueryCurrencyNameResponseDTO ret = new QueryCurrencyNameResponseDTO();
		try {
			ret.setBpi(currencyNameService.fetchCurrencyNameList());
			ret.setResult(SUCCESS);
			ret.setMessage("Query Success");
		} catch (Exception e) {
			ret.setResult(FAIL);
			ret.setMessage(StackTraceUtil.parse(e));
		}
		return ret;
	}
	
	@RequestMapping("/updateCurrencyName")
	public UpdateCurrencyNameResponseDTO update(@RequestBody UpdateCurrencyNameRequestDTO dto) throws Exception {
		UpdateCurrencyNameResponseDTO ret = new UpdateCurrencyNameResponseDTO();
		ret.setRequest(dto);
		try {
			currencyNameService.updateCurrencyName(dto);
			ret.setResult(SUCCESS);
			ret.setMessage("Update Success");
		} catch(Exception e) {
			ret.setResult(FAIL);
			ret.setMessage(StackTraceUtil.parse(e));
		}
		return ret;
	}
	
	@RequestMapping("/deleteCurrencyName")
	public DeleteCurrencyNameResponseDTO delete(@RequestBody DeleteCurrencyNameRequestDTO dto) throws Exception {
		DeleteCurrencyNameResponseDTO ret = new DeleteCurrencyNameResponseDTO();
		try {
			currencyNameService.deleteCurrencyNameById(dto.getCode());
			ret.setResult(SUCCESS);
			ret.setMessage("Delete Success");
		} catch(Exception e) {
			ret.setResult(FAIL);
			ret.setMessage(StackTraceUtil.parse(e));
		}
		return ret;
	}
}
