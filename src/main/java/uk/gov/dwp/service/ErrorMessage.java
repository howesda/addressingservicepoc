package uk.gov.dwp.service;

public 	class ErrorMessage {
	private int status = 500;
	private String message;
		
	public ErrorMessage(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getStatus() {
		return status;
	}
}