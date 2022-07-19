package com.api;

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

@RestController
public class CallCoinDesk {

	private static final String URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	
	
	@RequestMapping("/coinDesk")
	public CallResponseDTO call() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new JavascriptHttpMessageConverter());
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);

        CoinDeskResponseDTO coinDeskRes = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, CoinDeskResponseDTO.class).getBody();
        
        return CoinDeskToCallConverter.convert(coinDeskRes);

	}
}
