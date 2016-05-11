package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.Address;
import com.qas.ondemand_2011_03.AddressLineType;
import com.qas.ondemand_2011_03.QAAddressType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;
import java.util.Map;

public class UprnSearchOutboundAdapterDatabase implements Processor {
    private static final String BUILDING_NUMBER = "Building Number";
    private static final String BUILDING_NAME = "Building Name";
    private static final String SUB_BUILDING_NAME = "Sub Building Name";
    private static final String ORGANISATION_NAME = "Organisation Name";
    private static final String THOROUGHFARE_NAME = "Thoroughfare Name";
    private static final String DEPENDENT_LOCALITY = "Dependent Locality";
    private static final String POSTTOWN = "Posttown";
    private static final String POSTCODE = "Postcode";
    private static final String PO_BOX_NUMBER = "PO Box Number";

	/**
	 * @param exchange the exchange to process
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> rows = exchange.getIn().getBody(List.class);
		Address address = new Address();
		
		// TODO: Sort out error handling

		Map<String, Object> row = rows.get(0);

		QAAddressType addressType = new QAAddressType();
		address.setQAAddress(addressType);
		addAddressLineType(addressType, BUILDING_NUMBER, (String)row.get("building_number"));
		addAddressLineType(addressType, BUILDING_NAME, (String)row.get("building_name"));
		addAddressLineType(addressType, SUB_BUILDING_NAME, (String)row.get("sub_building_name"));
		addAddressLineType(addressType, ORGANISATION_NAME, (String)row.get("organisation_name"));
		addAddressLineType(addressType, THOROUGHFARE_NAME, (String)row.get("thoroughfare"));
		addAddressLineType(addressType, DEPENDENT_LOCALITY, (String)row.get("dependent_locality"));
		addAddressLineType(addressType, POSTTOWN, (String)row.get("post_town"));
		addAddressLineType(addressType, POSTCODE, (String)row.get("postcode"));
		addAddressLineType(addressType, PO_BOX_NUMBER, (String)row.get("po_box_number"));

		exchange.getOut().setBody(address);
	}
	
	private void addAddressLineType(QAAddressType addressType, String label, String value) {
		if (label != null && value != null) {
			AddressLineType addressLineType = new AddressLineType();
			addressLineType.setLabel(label);
			addressLineType.setLine(value);
			addressType.getAddressLine().add(addressLineType);
		}
	}
}
