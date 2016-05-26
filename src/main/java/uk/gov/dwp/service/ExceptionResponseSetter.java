package uk.gov.dwp.service;

import org.apache.camel.Exchange;

public interface ExceptionResponseSetter {

	void setResponse(Exchange exchange, Exception exception) throws Exception;

}
