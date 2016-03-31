package uk.gov.dwp.service.osplaces.postcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Adapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Adapter.class);

    /**
	 * @param response the response to process
	 */
	public Response handlePostcodeResponse(Response response) {
		LOGGER.info("handlePostcodeResponse - response:\n " + response.toString());
		return response;
	}
}
