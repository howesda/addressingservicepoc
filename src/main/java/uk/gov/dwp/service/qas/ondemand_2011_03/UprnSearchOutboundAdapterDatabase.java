package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.Address;
import com.qas.ondemand_2011_03.AddressLineType;
import com.qas.ondemand_2011_03.QAAddressType;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import uk.gov.dwp.service.osplaces.postcode.Response;
import uk.gov.dwp.service.osplaces.postcode.ResponseResult;

import java.util.List;

// TODO - NJM: Modify to retrieve the results according to the database format

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

	@Override
	public void process(Exchange exchange) throws Exception {
		Response response = exchange.getIn().getBody(Response.class);
		Address address = new Address();
		
		// TODO - NJM: Sort out error handling
		
		if (response.getResults().isPresent()) {
			List<ResponseResult> results = response.getResults().get();
			ResponseResult responseResult = results.get(0);
	
			QAAddressType addressType = new QAAddressType();
			address.setQAAddress(addressType);
			addAddressLineType(addressType, BUILDING_NUMBER, responseResult.getDpa().getBuildingNumber());
			addAddressLineType(addressType, BUILDING_NAME, responseResult.getDpa().getBuildingName());
			addAddressLineType(addressType, SUB_BUILDING_NAME, responseResult.getDpa().getSubBuildingName());
			addAddressLineType(addressType, ORGANISATION_NAME, responseResult.getDpa().getOrganisationName());
			addAddressLineType(addressType, THOROUGHFARE_NAME, responseResult.getDpa().getThoroughfareName());
			addAddressLineType(addressType, DEPENDENT_LOCALITY, responseResult.getDpa().getDependentLocality());
			addAddressLineType(addressType, POSTTOWN, responseResult.getDpa().getPosttown());
			addAddressLineType(addressType, POSTCODE, responseResult.getDpa().getPostcode());
			addAddressLineType(addressType, PO_BOX_NUMBER, responseResult.getDpa().getPoBoxNumber());
		}
		
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
