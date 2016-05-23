package uk.gov.dwp.service.qas.ondemand_2011_03;

import org.apache.camel.Exchange;
import uk.gov.dwp.service.ExceptionResponseSetter;

public class QASExceptionResponseSetter implements ExceptionResponseSetter {
	
	@Override
	public void setResponse(Exchange exchange,Exception exception) throws Exception {

		// TODO - Sort out how errors encountered while processing the SOAP message are returned to the client
		System.out.println("Exception Encountered : " + exception.getMessage());
		
		// We intentionally allow this message to crash the exchange until we sort out what needs to be done.
	}
}
