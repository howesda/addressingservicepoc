package uk.gov.dwp.service.osplaces;

import org.apache.camel.Exchange;

public class DefaultResponseSetter implements ExceptionResponseSetter {

	@Override
	public void setResponse(Exchange exchange, Exception exception) throws Exception {
		
		// TODO - this doesn't work correctly yet - for a SOAP message we still get some payload which we could probably do without, for a REST message this gets translated in to an HTTP 204 rseponse somehow.

		exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE,500);
	}

}
