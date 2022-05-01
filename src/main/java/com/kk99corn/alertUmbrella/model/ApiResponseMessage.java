package com.kk99corn.alertUmbrella.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponseMessage {
	private int status;
	private String description;
	private Object data;

	public ApiResponseMessage() {
		this.status = 400;
		this.data = null;
		this.description = "bad request";
	}
}
