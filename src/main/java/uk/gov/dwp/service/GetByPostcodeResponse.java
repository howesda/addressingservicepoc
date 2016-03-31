package uk.gov.dwp.service;

import java.util.List;

public class GetByPostcodeResponse {
	private List<GetByPostcodeResponseResult> results;

	/**
	 * @return the results
	 */
	public List<GetByPostcodeResponseResult> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(List<GetByPostcodeResponseResult> results) {
		this.results = results;
	}
}
