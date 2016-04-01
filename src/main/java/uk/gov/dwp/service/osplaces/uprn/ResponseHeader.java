package uk.gov.dwp.service.osplaces.uprn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {
	private String uri;
	private String query;
    private int offset;
    private int totalResults;
    private String format;
    private String dataset;
    private String lr;
    private int maxResults;
    private String epoch;
    private String outputSrs;

    /**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	@JsonProperty("uri")
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query the query to set
	 */
	@JsonProperty("query")
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @param offset the offset to set
	 */
	@JsonProperty("offset")
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the totalResults
	 */
	public int getTotalResults() {
		return totalResults;
	}

	/**
	 * @param totalResults the totalResults to set
	 */
	@JsonProperty("totalresults")
	public void setTotalresults(int totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	@JsonProperty("format")
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * @return the dataset
	 */
	public String getDataset() {
		return dataset;
	}

	/**
	 * @param dataset the dataset to set
	 */
	@JsonProperty("dataset")
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	/**
	 * @return the lr
	 */
	public String getLr() {
		return lr;
	}

	/**
	 * @param lr the lr to set
	 */
	@JsonProperty("lr")
	public void setLr(String lr) {
		this.lr = lr;
	}

	/**
	 * @return the maxResults
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * @param maxResults the maxResults to set
	 */
	@JsonProperty("maxresults")
	public void setMaxresults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * @return the epoch
	 */
	public String getEpoch() {
		return epoch;
	}

	/**
	 * @param epoch the epoch to set
	 */
	@JsonProperty("epoch")
	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}

	/**
	 * @return the outputSrs
	 */
	public String getOutputSrs() {
		return outputSrs;
	}

	/**
	 * @param outputSrs the outputSrs to set
	 */
	@JsonProperty("output_srs")
	public void setOutputSrs(String outputSrs) {
		this.outputSrs = outputSrs;
	}
}
