package uk.gov.dwp.service.osplaces;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.gov.dwp.service.ErrorMessage;

public class ExceptionProcessor implements Processor {
	
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public void process(Exchange exchange) throws Exception {
		Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
		
		ErrorMessage message = new ErrorMessage(exception.getMessage());

		Response response = Response.serverError().entity(mapper.writeValueAsString(message)).build();
        exchange.getOut().setBody(response);
		
	}
}
