package uk.gov.dwp.service.osplaces.postcode;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
	private ResponseHeader header;
	private Optional<List<ResponseResult>> results = Optional.empty();
	private Optional<RemoteError> error = Optional.empty();

	/**
	 * @return the header
	 */
	public ResponseHeader getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	@JsonProperty("header")
	public void setHeader(ResponseHeader header) {
		this.header = header;
	}

	/**
	 * @return the results
	 */
	public Optional<List<ResponseResult>> getResults() {
		return results;
	}

	/**
	 * @param results the results to set
	 */
	@JsonProperty("results")
	public void setResults(List<ResponseResult> results) {
		this.results = Optional.of(results);
	}

	public Optional<RemoteError> getError() {
		return error;
	}

	public void setError(RemoteError error) {
		this.error = Optional.of(error);
	}
}
