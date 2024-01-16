package com.CompitApplication.Component;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
public class SmsOtp {

	@JsonIgnore
	String number;
	
	String otp;

	public SmsOtp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmsOtp(String number, String otp) {
		super();
		this.number = number;
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "SmsOtp [number=" + number + ", otp=" + otp + "]";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

	
}