package com.api.converter;

import java.time.format.DateTimeFormatter;

import com.api.dto.call.Bpi;
import com.api.dto.call.CallResponseDTO;
import com.api.dto.call.EUR;
import com.api.dto.call.GBP;
import com.api.dto.call.USD;
import com.api.dto.coindesk.CoinDeskResponseDTO;

public class CoinDeskToCallConverter {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
	
	private CoinDeskToCallConverter() {
	}
	
	public static CallResponseDTO convert(CoinDeskResponseDTO coinDeskDTO) {
		CallResponseDTO res = new CallResponseDTO();
		res.setUpdateTime(coinDeskDTO.getTime().getUpdatedISO().format(formatter));
		
		com.api.dto.coindesk.Bpi bpi = coinDeskDTO.getBpi();
		
		Bpi resBpi = new Bpi();
		
		EUR eur = new EUR();
		eur.setCode(bpi.getEUR().getCode());
		eur.setName("test1");
		eur.setRateFloat(bpi.getEUR().getRateFloat());
		resBpi.setEUR(eur);

		GBP gbp = new GBP();
		gbp.setCode(bpi.getGBP().getCode());
		gbp.setName("test2");
		gbp.setRateFloat(bpi.getGBP().getRateFloat());
		resBpi.setGBP(gbp);
		
		USD usd = new USD();
		usd.setCode(bpi.getUSD().getCode());
		usd.setName("test3");
		usd.setRateFloat(bpi.getUSD().getRateFloat());
		resBpi.setUSD(usd);
		
		res.setBpi(resBpi);
		return res;
	}
}
