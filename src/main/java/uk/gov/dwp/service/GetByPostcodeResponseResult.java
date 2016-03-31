package uk.gov.dwp.service;

public class GetByPostcodeResponseResult {
	private String uprn;
	private String address;
	private String buildingNumber;
	private String buildingName;
	private String subBuildingName;
	private String organisationName;
	private String thoroughfareName;
    private String dependentLocality;
    private String posttown;
    private String postcode;
    private String poBoxNumber;

    /**
	 * @return the uprn
	 */
	public String getUprn() {
		return uprn;
	}

	/**
	 * @param uprn the uprn to set
	 */
	public void setUprn(String uprn) {
		this.uprn = uprn;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the buildingNumber
	 */
	public String getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * @param buildingNumber the buildingNumber to set
	 */
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the subBuildingName
	 */
	public String getSubBuildingName() {
		return subBuildingName;
	}

	/**
	 * @param subBuildingName the subBuildingName to set
	 */
	public void setSubBuildingName(String subBuildingName) {
		this.subBuildingName = subBuildingName;
	}

	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	/**
	 * @param organisationName the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	/**
	 * @return the thoroughfareName
	 */
	public String getThoroughfareName() {
		return thoroughfareName;
	}

	/**
	 * @param thoroughfareName the thoroughfareName to set
	 */
	public void setThoroughfareName(String thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}

	/**
	 * @return the dependentLocality
	 */
	public String getDependentLocality() {
		return dependentLocality;
	}

	/**
	 * @param dependentLocality the dependentLocality to set
	 */
	public void setDependentLocality(String dependentLocality) {
		this.dependentLocality = dependentLocality;
	}

	/**
	 * @return the posttown
	 */
	public String getPosttown() {
		return posttown;
	}

	/**
	 * @param posttown the posttown to set
	 */
	public void setPosttown(String posttown) {
		this.posttown = posttown;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the poBoxNumber
	 */
	public String getPoBoxNumber() {
		return poBoxNumber;
	}

	/**
	 * @param poBoxNumber the poBoxNumber to set
	 */
	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}
}
