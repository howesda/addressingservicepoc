package uk.gov.dwp.service;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AddressingServiceApp implements CamelContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressingServiceApp.class);
    private CamelContext camelContext;

	/**
	 * @param applicationContext
	 *            the applicationContext for Spring.
	 */
    public void start(ApplicationContext applicationContext) throws Exception {
		camelContext.start();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					camelContext.stop();
					((ConfigurableApplicationContext)applicationContext).close();
					LOGGER.info("AddressingService shutdown completed");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
            }
		});
		LOGGER.info("AddressingService startup completed");
		while (true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	@Override
	public CamelContext getCamelContext() {
		return camelContext;
	}

	@Override
	public void setCamelContext(CamelContext arg0) {
		camelContext = arg0;
	}
}
