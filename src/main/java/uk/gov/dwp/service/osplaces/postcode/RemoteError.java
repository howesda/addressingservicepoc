package uk.gov.dwp.service.osplaces.postcode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemoteError {
	@JsonProperty("statuscode")
	private String statusCode;
	private String message;
	
	public String getStatuscode() {
		return statusCode;
	}
	
	public void setStatuscode(String statuscode) {
		this.statusCode = statuscode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
