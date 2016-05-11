package uk.gov.dwp.service.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import uk.gov.dwp.service.GetByPostcodeResponse;
import uk.gov.dwp.service.GetByPostcodeResponseResult;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Adapter implements Processor {
	private static final String ADDRESS_DELIMETER = ", ";

	private ObjectMapper mapper = new ObjectMapper();

	private String buildAddress(GetByPostcodeResponseResult getByPostcodeResponseResult) {
		StringBuilder address = new StringBuilder();
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getOrganisationName())
				? getByPostcodeResponseResult.getOrganisationName() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getPoBoxNumber())
				? getByPostcodeResponseResult.getPoBoxNumber() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getSubBuildingName())
				? getByPostcodeResponseResult.getSubBuildingName() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getBuildingName())
				? getByPostcodeResponseResult.getBuildingName() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getBuildingNumber())
				? getByPostcodeResponseResult.getBuildingNumber() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getThoroughfareName())
				? getByPostcodeResponseResult.getThoroughfareName() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getDependentLocality())
				? getByPostcodeResponseResult.getDependentLocality() + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank(getByPostcodeResponseResult.getPosttown())
				? getByPostcodeResponseResult.getPosttown() + ADDRESS_DELIMETER : "");
		// Assume that postcode is always present even though the table definition permits a null value
		address.append(getByPostcodeResponseResult.getPostcode());
		return address.toString();
	}

    /**
	 * @param exchange the exchange to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		GetByPostcodeResponse getByPostcodeResponse = new GetByPostcodeResponse();
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = exchange.getIn().getBody(List.class);

		if (rows.size() == 0) {
			Response response = Response.status(Status.NOT_FOUND).build();
			exchange.getOut().setBody(response);
			return;
		}

		getByPostcodeResponse.setResults(new ArrayList<GetByPostcodeResponseResult>());
		for (Map<String, Object> row : rows) {
			GetByPostcodeResponseResult getByPostcodeResponseResult = new GetByPostcodeResponseResult();
			getByPostcodeResponseResult.setUprn(((Long)row.get("uprn")).toString());
			getByPostcodeResponseResult.setBuildingNumber((String)row.get("building_number"));
			getByPostcodeResponseResult.setBuildingName((String)row.get("building_name"));
			getByPostcodeResponseResult.setSubBuildingName((String)row.get("sub_building_name"));
			getByPostcodeResponseResult.setOrganisationName((String)row.get("organisation_name"));
			getByPostcodeResponseResult.setThoroughfareName((String)row.get("thoroughfare"));
			getByPostcodeResponseResult.setDependentLocality((String)row.get("dependent_locality"));
			getByPostcodeResponseResult.setPosttown((String)row.get("post_town"));
			getByPostcodeResponseResult.setPostcode((String)row.get("postcode"));
			getByPostcodeResponseResult.setPoBoxNumber((String)row.get("po_box_number"));
			getByPostcodeResponseResult.setAddress(buildAddress(getByPostcodeResponseResult));
			getByPostcodeResponse.getResults().add(getByPostcodeResponseResult);
		}

		exchange.getOut().setBody(mapper.writeValueAsString(getByPostcodeResponse));
	}
}
