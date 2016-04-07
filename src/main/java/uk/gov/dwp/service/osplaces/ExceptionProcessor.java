package uk.gov.dwp.service.osplaces;

import javax.ws.rs.core.Response;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.gov.dwp.service.ErrorMessage;

public class ExceptionProcessor implements Processor {
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);

		if ( exchange.getFromEndpoint().getEndpointUri().startsWith("cxfrs") ){
			ErrorMessage message = new ErrorMessage(exception.getMessage());
	
			Response response = Response.serverError().entity(mapper.writeValueAsString(message)).build();
	        exchange.getOut().setBody(response);		
		} else {
			// TODO - error handling for SOAP requests still need to be confirmed
			System.out.println("SOAP error handling still to be confirmed");
		}
	}
}
