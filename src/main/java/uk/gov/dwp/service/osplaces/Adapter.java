package uk.gov.dwp.service.osplaces;

import java.util.ArrayList;

import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.gov.dwp.service.ErrorMessage;
import uk.gov.dwp.service.GetByPostcodeResponse;
import uk.gov.dwp.service.GetByPostcodeResponseResult;
import uk.gov.dwp.service.osplaces.postcode.RemoteError;
import uk.gov.dwp.service.osplaces.postcode.Response;
import uk.gov.dwp.service.osplaces.postcode.ResponseResult;

public class Adapter implements Processor{
	
	private ObjectMapper mapper = new ObjectMapper();
    /**
	 * @param response the response to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		GetByPostcodeResponse getByPostcodeResponse = new GetByPostcodeResponse();
		Response response = exchange.getIn().getBody(Response.class);

		if ( response.getError().isPresent()){
			RemoteError error = response.getError().get();
			ResponseBuilder builder = null;
			if ( error.getStatuscode().equals("400") ){
				builder = javax.ws.rs.core.Response.status(Status.BAD_REQUEST);
				builder.entity(mapper.writeValueAsString(new ErrorMessage(error.getMessage())));
			}
			javax.ws.rs.core.Response resp = builder.build();
			exchange.getOut().setBody(resp);
			return;
		}
		
		if (response.getHeader().getTotalResults() == 0){
			javax.ws.rs.core.Response resp = javax.ws.rs.core.Response.status(Status.NOT_FOUND).build();
			exchange.getOut().setBody(resp);
			return;
		}

		if (response.getResults().isPresent()){
			getByPostcodeResponse.setResults(new ArrayList<GetByPostcodeResponseResult>());
			for (ResponseResult responseResult : response.getResults().get()) {
				GetByPostcodeResponseResult getByPostcodeResponseResult = new GetByPostcodeResponseResult();
				getByPostcodeResponseResult.setUprn(responseResult.getDpa().getUprn());
				getByPostcodeResponseResult.setAddress(responseResult.getDpa().getAddress());
				getByPostcodeResponseResult.setBuildingNumber(responseResult.getDpa().getBuildingNumber());
				getByPostcodeResponseResult.setBuildingName(responseResult.getDpa().getBuildingName());
				getByPostcodeResponseResult.setSubBuildingName(responseResult.getDpa().getSubBuildingName());
				getByPostcodeResponseResult.setOrganisationName(responseResult.getDpa().getOrganisationName());
				getByPostcodeResponseResult.setThoroughfareName(responseResult.getDpa().getThoroughfareName());
				getByPostcodeResponseResult.setDependentLocality(responseResult.getDpa().getDependentLocality());
				getByPostcodeResponseResult.setPosttown(responseResult.getDpa().getPosttown());
				getByPostcodeResponseResult.setPostcode(responseResult.getDpa().getPostcode());
				getByPostcodeResponseResult.setPoBoxNumber(responseResult.getDpa().getPoBoxNumber());
				getByPostcodeResponse.getResults().add(getByPostcodeResponseResult);
			}
		}

		
		exchange.getOut().setBody(mapper.writeValueAsString(getByPostcodeResponse));
	}

}
