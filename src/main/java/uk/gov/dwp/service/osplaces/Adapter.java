package uk.gov.dwp.service.osplaces;

import java.util.ArrayList;

import uk.gov.dwp.service.ErrorMessage;
import uk.gov.dwp.service.GetByPostcodeResponse;
import uk.gov.dwp.service.GetByPostcodeResponseResult;
import uk.gov.dwp.service.osplaces.postcode.Response;
import uk.gov.dwp.service.osplaces.postcode.ResponseResult;

public class Adapter {
    /**
	 * @param response the response to process
	 */
	public GetByPostcodeResponse handlePostcodeResponse(Response response) {
		GetByPostcodeResponse getByPostcodeResponse = new GetByPostcodeResponse();

		if ( response.getError().isPresent()){
			getByPostcodeResponse.setError(new ErrorMessage(400,response.getError().get().getMessage()));
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
		return getByPostcodeResponse;
	}
}
