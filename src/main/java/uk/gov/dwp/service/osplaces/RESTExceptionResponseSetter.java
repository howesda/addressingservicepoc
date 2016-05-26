package uk.gov.dwp.service.osplaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.http.common.HttpOperationFailedException;
import uk.gov.dwp.service.ErrorMessage;
import uk.gov.dwp.service.ExceptionResponseSetter;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


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
