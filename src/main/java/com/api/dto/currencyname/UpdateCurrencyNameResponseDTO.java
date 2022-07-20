package com.api.dto.currencyname;

public class UpdateCurrencyNameResponseDTO {

	private String result;
	private String message;
	private UpdateCurrencyNameRequestDTO request;
	
	
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
	public UpdateCurrencyNameRequestDTO getRequest() {
		return request;
	}
	public void setRequest(UpdateCurrencyNameRequestDTO request) {
		this.request = request;
	}
	
	
}
