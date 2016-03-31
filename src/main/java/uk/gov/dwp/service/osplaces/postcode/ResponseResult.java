package uk.gov.dwp.service.osplaces.postcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseResult {
	private ResponseResultDpa dpa;

	/**
	 * @return the dpa
	 */
	public ResponseResultDpa getDpa() {
		return dpa;
	}

	/**
	 * @param dpa the dpa to set
	 */
	@JsonProperty("DPA")
	public void setDpa(ResponseResultDpa dpa) {
		this.dpa = dpa;
	}
}
