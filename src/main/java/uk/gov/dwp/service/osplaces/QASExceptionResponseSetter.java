package uk.gov.dwp.service.osplaces;

import org.apache.camel.Exchange;

public class QASExceptionResponseSetter implements ExceptionResponseSetter {
	
	@Override
	public void setResponse(Exchange exchange,Exception exception) throws Exception {

		// TODO - Sort out how errors encountered while processing the SOAP message are returned to the client
		System.out.println("Exception Encountered : " + exception.getMessage());
		
		// We intentionally allow this message to crash the exchange until we sort out what needs to be done.
	}
}
