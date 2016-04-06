package uk.gov.dwp.service.qas.ondemand_2011_03;

import com.qas.ondemand_2011_03.QAGetAddress;

public class UprnSearchInboundAdapter{

    /**
	 * @param getAddress the getAddress to process
	 */
	public String handleAddressRequest(QAGetAddress getAddress) {
		return getAddress.getMoniker();
	}


}
