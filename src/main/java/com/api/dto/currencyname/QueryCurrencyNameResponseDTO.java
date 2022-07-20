package com.api.dto.currencyname;

import java.util.List;

public class QueryCurrencyNameResponseDTO {

	private String result;
	private String message;
	private List<CurrencyNameDTO> bpi;


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<CurrencyNameDTO> getBpi() {
		return bpi;
	}

	public void setBpi(List<CurrencyNameDTO> bpi) {
		this.bpi = bpi;
	}
	
}
