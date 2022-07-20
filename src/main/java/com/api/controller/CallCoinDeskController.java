package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.converter.CoinDeskToCallConverter;
import com.api.converter.JavascriptHttpMessageConverter;
import com.api.dto.call.CallResponseDTO;
import com.api.dto.coindesk.CoinDeskResponseDTO;
import com.api.dto.currencyname.CurrencyNameDTO;
import com.api.service.CurrencyNameService;

@RestController
public class CallCoinDeskController {

	@Autowired
	private CurrencyNameService currencyNameService;
	
	private static final String URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	
	
	@RequestMapping("/callCoinDesk")
	public CoinDeskResponseDTO call() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new JavascriptHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);

        return restTemplate.exchange(URL, HttpMethod.GET, httpEntity, CoinDeskResponseDTO.class).getBody();
	}
	
	@RequestMapping("/callCoinDeskAndParse")
	public CallResponseDTO callAndParse() throws Exception {
        CoinDeskResponseDTO coinDeskRes = call();
        List<CurrencyNameDTO> dtoList = currencyNameService.fetchCurrencyNameList();
        return CoinDeskToCallConverter.convert(coinDeskRes, dtoList);
	}
}
