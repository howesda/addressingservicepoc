package uk.gov.dwp.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

public class ExceptionProcessor implements Processor {
	
	private Map<String,ExceptionResponseSetter> responseSetterMap = new HashMap<>();

	@Override
	public void process(Exchange exchange) throws Exception {
		Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
				
		ExceptionResponseSetter responseSetter = getResponseSetter(exchange);
		
		responseSetter.setResponse(exchange, exception);

	}

	private synchronized ExceptionResponseSetter getResponseSetter(Exchange exchange) {
		
		String responseSetterName = exchange.getProperty("EXCEPTION_RESPONSE_SETTER",String.class);
		
		ExceptionResponseSetter responseSetter = responseSetterMap.get(responseSetterName);
		
		if ( null == responseSetter ) {
			responseSetter = (ExceptionResponseSetter) exchange.getContext().getRegistry().lookupByName(exchange.getProperty("EXCEPTION_RESPONSE_SETTER",String.class));
			if ( null == responseSetter ){
				responseSetter = new DefaultResponseSetter();
			}
			responseSetterMap.put(responseSetterName, responseSetter);
		}
		
		return responseSetter;
	}
}
