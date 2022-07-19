package com.api.dto.coindesk;

import java.time.LocalDateTime;

public class Time {
	private String updated;
	private LocalDateTime updatedISO;
	private String updateduk;
	
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public LocalDateTime getUpdatedISO() {
		return updatedISO;
	}
	public void setUpdatedISO(LocalDateTime updatedISO) {
		this.updatedISO = updatedISO;
	}
	public String getUpdateduk() {
		return updateduk;
	}
	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}
	
	
}
