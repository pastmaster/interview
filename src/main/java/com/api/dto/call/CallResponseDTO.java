package com.api.dto.call;

import java.util.List;

public class CallResponseDTO {

	private String updateTime;
	private List<Bpi> bpiList;
	
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public List<Bpi> getBpiList() {
		return bpiList;
	}
	public void setBpiList(List<Bpi> bpiList) {
		this.bpiList = bpiList;
	}
	
	
}
