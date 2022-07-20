package com.api.dto.currencyname;

public class InsertCurrencyNameResponseDTO {

	private String result;
	private String message;
	private InsertCurrencyNameRequestDTO request;
	
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
	public InsertCurrencyNameRequestDTO getRequest() {
		return request;
	}
	public void setRequest(InsertCurrencyNameRequestDTO request) {
		this.request = request;
	}
	
	
}
