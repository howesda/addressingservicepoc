package uk.gov.dwp.service.osplaces;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.gov.dwp.service.ErrorMessage;


public class RESTExceptionResponseSetter implements ExceptionResponseSetter {
	
	@Override
	public void setResponse(Exchange exchange,Exception exception) throws Exception {
		ErrorMessage message = new ErrorMessage(exception.getMessage());
		
		ResponseBuilder responseBuilder = Response.serverError();
		
		if (exception instanceof HttpOperationFailedException){
			HttpOperationFailedException httpEx = (HttpOperationFailedException)exception;
			responseBuilder = Response.status(httpEx.getStatusCode());
		}

		ObjectMapper mapper = new ObjectMapper();

		Response response = responseBuilder.entity(mapper.writeValueAsString(message)).build();
		exchange.getOut().setBody(response);		

	}
}
