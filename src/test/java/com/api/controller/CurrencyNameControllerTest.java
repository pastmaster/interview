package com.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.api.dto.currencyname.CurrencyNameDTO;
import com.api.dto.currencyname.DeleteCurrencyNameRequestDTO;
import com.api.dto.currencyname.InsertCurrencyNameRequestDTO;
import com.api.dto.currencyname.UpdateCurrencyNameRequestDTO;
import com.api.exception.APException;
import com.api.service.CurrencyNameService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = CurrencyNameController.class)
class CurrencyNameControllerTest {

	@MockBean
	private CurrencyNameService currencyNameService;
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	
	@Test
	public void insertSuccess() throws Exception {
		doNothing().when(currencyNameService).insert(any());

		InsertCurrencyNameRequestDTO request = new InsertCurrencyNameRequestDTO();
		request.setCode("USD");
		request.setName("美金");
		
		mockMvc.perform(get("/insertCurrencyName").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value("Success"))
        .andDo(print());
	}

	@Test
	public void insertFail() throws Exception {
		doThrow(new APException("duplicate")).when(currencyNameService).insert(any());
		
		InsertCurrencyNameRequestDTO request = new InsertCurrencyNameRequestDTO();
		request.setCode("USD");
		request.setName("美金");
		
		mockMvc.perform(get("/insertCurrencyName").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value("Fail"))
        .andDo(print());
	}

	@Test
	public void querySuccess() throws Exception {
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
		
		mockMvc.perform(get("/queryCurrencyName"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value("Success"))
        .andDo(print());
	}

	@Test
	public void updateSuccess() throws Exception {
		doNothing().when(currencyNameService).updateCurrencyName(any());

		UpdateCurrencyNameRequestDTO request = new UpdateCurrencyNameRequestDTO();
		request.setCode("USD");
		request.setName("測試");
		
		mockMvc.perform(get("/updateCurrencyName").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value("Success"))
        .andDo(print());
	}

	@Test
	public void deleteSuccess() throws Exception {
		doNothing().when(currencyNameService).deleteCurrencyNameById(any());
		
		DeleteCurrencyNameRequestDTO request = new DeleteCurrencyNameRequestDTO();
		request.setCode("USD");
		
		mockMvc.perform(get("/deleteCurrencyName").contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.result").value("Success"))
        .andDo(print());
	}
	
}
