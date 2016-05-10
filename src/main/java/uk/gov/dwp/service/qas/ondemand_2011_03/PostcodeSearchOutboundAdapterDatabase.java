package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.PicklistEntryType;
import com.qas.ondemand_2011_03.QAPicklistType;
import com.qas.ondemand_2011_03.QASearchResult;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import uk.gov.dwp.service.osplaces.postcode.Response;
import uk.gov.dwp.service.osplaces.postcode.ResponseResult;

import java.math.BigInteger;
import java.util.List;

public class PostcodeSearchOutboundAdapterDatabase implements Processor {

	// TODO - NJM: Modify to retrieve the results according to the database format

	/**
	 * @param response the response to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		Response response = exchange.getIn().getBody(Response.class);

		QASearchResult searchResult = new QASearchResult();
		QAPicklistType picklistType = new QAPicklistType();
		searchResult.setQAPicklist(picklistType);

		// TODO - NJM: Sort out error handling

		if (response.getResults().isPresent()) {
			List<ResponseResult> results = response.getResults().get();
			picklistType.setTotal(new BigInteger(new Integer(results.size()).toString()));
			for (ResponseResult responseResult : results) {
				PicklistEntryType picklistEntryType = new PicklistEntryType();
				picklistEntryType.setMoniker(responseResult.getDpa().getUprn());
				picklistEntryType.setPicklist(responseResult.getDpa().getAddress());
				picklistType.getPicklistEntry().add(picklistEntryType);
			}
		}
		exchange.getOut().setBody(searchResult);
	}

}
