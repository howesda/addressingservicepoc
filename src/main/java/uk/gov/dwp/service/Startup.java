package uk.gov.dwp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Startup {
    private static AddressingServiceApp addressingServiceApp;

	/**
	 * @param addressingServiceApp
	 *            the addressingServiceApp bean injected by Spring.
	 */
    @Autowired(required=true)
	public Startup(@Qualifier("addressingServiceApp") AddressingServiceApp addressingServiceApp) {
		Startup.addressingServiceApp = addressingServiceApp;
	}

	/**
	 * The entry point for running the Addressing Service standalone.
	 */
    public static void main(String[] args) throws Exception {
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cxf-config.xml","application-config.xml");
        Startup.addressingServiceApp.start(applicationContext);
	}
}
