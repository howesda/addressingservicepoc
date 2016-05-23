package uk.gov.dwp.service.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import uk.gov.dwp.service.ErrorMessage;
import uk.gov.dwp.service.ExceptionResponseSetter;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public class DatabaseExceptionResponseSetter implements ExceptionResponseSetter {
	
	@Override
	public void setResponse(Exchange exchange, Exception exception) throws Exception {
		ErrorMessage message = new ErrorMessage(exception.getMessage());
		
		ResponseBuilder responseBuilder = Response.serverError();
		
		if ((exception instanceof InvalidPostcodeException)
			|| (exception instanceof InvalidUprnException)) {
			responseBuilder = Response.status(Status.BAD_REQUEST);
		}

		ObjectMapper mapper = new ObjectMapper();

		Response response = responseBuilder.entity(mapper.writeValueAsString(message)).build();
		exchange.getOut().setBody(response);		
	}
}
