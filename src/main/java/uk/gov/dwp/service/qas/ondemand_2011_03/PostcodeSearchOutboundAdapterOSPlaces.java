package uk.gov.dwp.service.qas.ondemand_2011_03;

import java.math.BigInteger;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.qas.ondemand_2011_03.PicklistEntryType;
import com.qas.ondemand_2011_03.QAPicklistType;
import com.qas.ondemand_2011_03.QASearchResult;

import uk.gov.dwp.service.osplaces.postcode.Response;
import uk.gov.dwp.service.osplaces.postcode.ResponseResult;

public class PostcodeSearchOutboundAdapterOSPlaces implements Processor{


	/**
	 * @param response the response to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		Response response = exchange.getIn().getBody(Response.class);
		
		QASearchResult searchResult = new QASearchResult();
		QAPicklistType picklistType = new QAPicklistType();
		searchResult.setQAPicklist(picklistType);
		
		// TODO Need to add error handling here - it's unclear from the wsdl how errors are reported back to the user
		
		if (response.getResults().isPresent()){
			List<ResponseResult> results = response.getResults().get();
			picklistType.setTotal(new BigInteger(new Integer(results.size()).toString()));
			for (uk.gov.dwp.service.osplaces.postcode.ResponseResult responseResult : results) {
				PicklistEntryType picklistEntryType = new PicklistEntryType();
				picklistEntryType.setMoniker(responseResult.getDpa().getUprn());
				picklistEntryType.setPicklist(responseResult.getDpa().getAddress());
				picklistType.getPicklistEntry().add(picklistEntryType);
			}
		}
		exchange.getOut().setBody(searchResult);
	}



}
