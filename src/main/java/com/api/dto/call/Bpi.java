package com.api.dto.call;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {
	@JsonProperty("USD") 
    private USD uSD;
    @JsonProperty("GBP") 
    private GBP gBP;
    @JsonProperty("EUR") 
    private EUR eUR;
    
	public USD getuSD() {
		return uSD;
	}
	public void setUSD(USD uSD) {
		this.uSD = uSD;
	}
	public GBP getgBP() {
		return gBP;
	}
	public void setGBP(GBP gBP) {
		this.gBP = gBP;
	}
	public EUR geteUR() {
		return eUR;
	}
	public void setEUR(EUR eUR) {
		this.eUR = eUR;
	}
    
    
}
