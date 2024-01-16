package com.CompitApplication.Exception;

public class ParameterException extends Exception{
	
	
	public ParameterException(String message, Error error) {
		super(message);
	}

	public void  printStackTrace(ParameterException excep) {
		// TODO Auto-generated method stub
		this.getMessage();
	}
	

}
