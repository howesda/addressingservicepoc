package uk.gov.dwp.service.qas.ondemand_2011_03;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qas.ondemand_2011_03.Address;
import com.qas.ondemand_2011_03.QAGetAddress;
import com.qas.ondemand_2011_03.QASearch;
import com.qas.ondemand_2011_03.QASearchResult;

public class Adapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Adapter.class);

    /**
	 * @param search the search to process
	 */
	public QASearchResult handleSearchRequest(QASearch search) {
		logSearch(search);
		return new QASearchResult();
	}

    /**
	 * @param getAddress the getAddress to process
	 */
	public Address handleAddressRequest(QAGetAddress getAddress) {
		logGetAddress(getAddress);
		return new Address();
	}

	/**
	 * @param search the search to log
	 */
	private void logSearch(QASearch search) {
		// TODO: Temporary code to support debugging - remove when no longer required
		try {
			JAXBContext context = JAXBContext.newInstance(QASearch.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(search, stringWriter);
			LOGGER.info("handleSearchRequest - QASearch:\n " + stringWriter.toString());
		} catch (Exception e) {}
	}

	/**
	 * @param getAddress the getAddress to log
	 */
	private void logGetAddress(QAGetAddress getAddress) {
		// TODO: Temporary code to support debugging - remove when no longer required
		try {
			JAXBContext context = JAXBContext.newInstance(QAGetAddress.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(getAddress, stringWriter);
			LOGGER.info("handleAddressRequest - QAGetAddress:\n " + stringWriter.toString());
		} catch (Exception e) {}
	}
}
