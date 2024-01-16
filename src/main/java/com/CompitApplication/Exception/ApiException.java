package com.CompitApplication.Exception;

import com.CompitApplication.Logger.LoggingUtils;

public class ApiException extends RuntimeException {

	static LoggingUtils logger = new LoggingUtils(ApiException.class.getName());
	
	public ApiException(String message) {
		super(message);

	}

	public ApiException() {
		super();

	}

}