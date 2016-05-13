package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.PicklistEntryType;
import com.qas.ondemand_2011_03.QAPicklistType;
import com.qas.ondemand_2011_03.QASearchResult;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class PostcodeSearchOutboundAdapterDatabase implements Processor {
	private static final String ADDRESS_DELIMETER = ", ";

	private String buildAddress(Map<String, Object> row) {
		StringBuilder address = new StringBuilder();
		address.append(!StringUtils.isBlank((String)row.get("organisation_name"))
				? (String)row.get("organisation_name") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("po_box_number"))
				? (String)row.get("po_box_number") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("sub_building_name"))
				? (String)row.get("sub_building_name") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("building_name"))
				? (String)row.get("building_name") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("building_number"))
				? (String)row.get("building_number") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("thoroughfare"))
				? (String)row.get("thoroughfare") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("dependent_locality"))
				? (String)row.get("dependent_locality") + ADDRESS_DELIMETER : "");
		address.append(!StringUtils.isBlank((String)row.get("post_town"))
				? (String)row.get("post_town") + ADDRESS_DELIMETER : "");
		// Assume that postcode is always present even though the table definition permits a null value
		address.append((String)row.get("postcode"));
		return address.toString();
	}

	/**
	 * @param exchange the exchange to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = exchange.getIn().getBody(List.class);

		QASearchResult searchResult = new QASearchResult();
		QAPicklistType picklistType = new QAPicklistType();
		searchResult.setQAPicklist(picklistType);

		// TODO: Sort out error handling

		picklistType.setTotal(new BigInteger(new Integer(rows.size()).toString()));
		for (Map<String, Object> row : rows) {
			PicklistEntryType picklistEntryType = new PicklistEntryType();
			picklistEntryType.setMoniker(((Long)row.get("uprn")).toString());
			picklistEntryType.setPicklist(buildAddress(row));
			picklistType.getPicklistEntry().add(picklistEntryType);
		}

		exchange.getOut().setBody(searchResult);
	}
}
