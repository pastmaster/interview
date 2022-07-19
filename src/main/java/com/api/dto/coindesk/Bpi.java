package com.api.dto.coindesk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {
	@JsonProperty("USD") 
    private USD uSD;
    @JsonProperty("GBP") 
    private GBP gBP;
    @JsonProperty("EUR") 
    private EUR eUR;
    
	public USD getUSD() {
		return uSD;
	}
	public void setUSD(USD uSD) {
		this.uSD = uSD;
	}
	public GBP getGBP() {
		return gBP;
	}
	public void setGBP(GBP gBP) {
		this.gBP = gBP;
	}
	public EUR getEUR() {
		return eUR;
	}
	public void setEUR(EUR eUR) {
		this.eUR = eUR;
	}
    
    
}
