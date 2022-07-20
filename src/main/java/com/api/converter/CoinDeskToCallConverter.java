package com.api.converter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.dto.call.Bpi;
import com.api.dto.call.CallResponseDTO;
import com.api.dto.coindesk.CoinDeskResponseDTO;
import com.api.dto.currencyname.CurrencyNameDTO;

public class CoinDeskToCallConverter {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
	
	private CoinDeskToCallConverter() {
	}
	
	public static CallResponseDTO convert(CoinDeskResponseDTO coinDeskDTO, List<CurrencyNameDTO> dtoList) {
		Map<String, String> codeToNameMap = new HashMap<>();
		for (CurrencyNameDTO dto : dtoList)
			codeToNameMap.put(dto.getCode(), dto.getName());
		
		CallResponseDTO res = new CallResponseDTO();
		res.setUpdateTime(coinDeskDTO.getTime().getUpdatedISO().format(formatter));
		
		com.api.dto.coindesk.Bpi bpi = coinDeskDTO.getBpi();
		
		List<Bpi> resBpi = new ArrayList<>(3);
		Bpi eur = new Bpi();
		eur.setCode(bpi.getEUR().getCode());
		eur.setName(codeToNameMap.get(eur.getCode()));
		eur.setRateFloat(bpi.getEUR().getRateFloat());
		resBpi.add(eur);

		Bpi gbp = new Bpi();
		gbp.setCode(bpi.getGBP().getCode());
		gbp.setName(codeToNameMap.get(gbp.getCode()));
		gbp.setRateFloat(bpi.getGBP().getRateFloat());
		resBpi.add(gbp);
		
		Bpi usd = new Bpi();
		usd.setCode(bpi.getUSD().getCode());
		usd.setName(codeToNameMap.get(usd.getCode()));
		usd.setRateFloat(bpi.getUSD().getRateFloat());
		resBpi.add(usd);
		
		res.setBpiList(resBpi);
		return res;
	}
}
