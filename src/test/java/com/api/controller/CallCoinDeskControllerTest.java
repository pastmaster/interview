package com.api.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.api.dto.currencyname.CurrencyNameDTO;
import com.api.service.CurrencyNameService;

@WebMvcTest(value = CallCoinDeskController.class)
class CallCoinDeskControllerTest {

	@MockBean
	private CurrencyNameService currencyNameService;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void callSuccess() throws Exception {
		mockMvc.perform(post("/callCoinDesk"))
        .andExpect(status().isOk())
        .andDo(print());
	}
	
	@Test
	public void callAndParseSuccess() throws Exception {
		List<CurrencyNameDTO> currenyNameList = new ArrayList<>();
		CurrencyNameDTO usd = new CurrencyNameDTO();
		usd.setCode("USD");
		usd.setName("美金");
		currenyNameList.add(usd);
		CurrencyNameDTO gbp = new CurrencyNameDTO();
		gbp.setCode("GBP");
		gbp.setName("英鎊");
		currenyNameList.add(gbp);
		CurrencyNameDTO eur = new CurrencyNameDTO();
		eur.setCode("EUR");
		eur.setName("歐元");
		currenyNameList.add(eur);
		
		when(currencyNameService.fetchCurrencyNameList()).thenReturn(currenyNameList);
		mockMvc.perform(post("/callCoinDeskAndParse"))
        .andExpect(status().isOk())
        .andDo(print());
	}
	

}
