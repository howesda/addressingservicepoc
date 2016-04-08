package uk.gov.dwp.service.osplaces;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.gov.dwp.service.ErrorMessage;

public class RESTExceptionResponseSetter implements ExceptionResponseSetter {
	
	@Override
	public void setResponse(Exchange exchange,Exception exception) throws Exception {
		ErrorMessage message = new ErrorMessage(exception.getMessage());

		ObjectMapper mapper = new ObjectMapper();

		Response response = Response.serverError().entity(mapper.writeValueAsString(message)).build();
		exchange.getOut().setBody(response);		

	}
}
