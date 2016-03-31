package uk.gov.dwp.service.osplaces.postcode;

import java.util.ArrayList;

import uk.gov.dwp.service.GetByPostcodeResponse;
import uk.gov.dwp.service.GetByPostcodeResponseResult;

public class Adapter {
    /**
	 * @param response the response to process
	 */
	public GetByPostcodeResponse handlePostcodeResponse(Response response) {
		GetByPostcodeResponse getByPostcodeResponse = new GetByPostcodeResponse();
		getByPostcodeResponse.setResults(new ArrayList<GetByPostcodeResponseResult>());
		for (ResponseResult responseResult : response.getResults()) {
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
		return getByPostcodeResponse;
	}
}
