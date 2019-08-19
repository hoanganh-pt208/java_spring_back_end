package com.hoanganh.response;

import java.util.List;

public class ResponseModel {
	private List<? extends Object> data;
	private String status;
	
	public ResponseModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseModel(List<? extends Object> data, String status) {
		super();
		this.data = data;
		this.status = status;
	}

	public List<? extends Object> getData() {
		return data;
	}

	public void setData(List<? extends Object> list) {
		this.data = list;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
