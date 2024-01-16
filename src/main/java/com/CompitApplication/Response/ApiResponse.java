package com.CompitApplication.Response;

public class ApiResponse {

	private String message;
	private boolean success;
	private Object output;
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String message, boolean success, Object output) {
		super();
		this.message = message;
		this.success = success;
		this.output = output;
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", success=" + success + ", output=" + output + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getOutput() {
		return output;
	}
	public void setOutput(Object output) {
		this.output = output;
	}
}