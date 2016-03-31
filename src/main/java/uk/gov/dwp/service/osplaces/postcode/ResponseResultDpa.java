package uk.gov.dwp.service.osplaces.postcode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseResultDpa {
	private String uprn;
	private String udprn;
	private String address;
	private String buildingNumber;
	private String buildingName;
	private String subBuildingName;
	private String organisationName;
	private String thoroughfareName;
    private String doubleDependentLocality;
    private String dependentLocality;
    private String posttown;
    private String postcode;
    private String poBoxNumber;
    private String rpc;
    private double xCoordinate;
    private double yCoordinate;
    private String status;
    private String logicalStatusCode;
    private String classificationCode;
    private String classificationCodeDescription;
    private int localCustodianCode;
    private String localCustodianCodeDescription;
    private String postalAddressCode;
    private String postalAddressCodeDescription;
    private String blpuStateCode;
    private String blpuStateCodeDescription;
    private String topographyLayerToid;
    private String parentUprn;
    private String lastUpdateDate;
    private String entryDate;
    private String blpuStateDate;
    private String language;
    private double match;
    private String matchDescription;

    /**
	 * @return the uprn
	 */
	public String getUprn() {
		return uprn;
	}

	/**
	 * @param uprn the uprn to set
	 */
	@JsonProperty("UPRN")
	public void setUprn(String uprn) {
		this.uprn = uprn;
	}

	/**
	 * @return the udprn
	 */
	public String getUdprn() {
		return udprn;
	}

	/**
	 * @param udprn the udprn to set
	 */
	@JsonProperty("UDPRN")
	public void setUdprn(String udprn) {
		this.udprn = udprn;
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
	@JsonProperty("ADDRESS")
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
	@JsonProperty("BUILDING_NUMBER")
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
	@JsonProperty("BUILDING_NAME")
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
	@JsonProperty("SUB_BUILDING_NAME")
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
	@JsonProperty("ORGANISATION_NAME")
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
	@JsonProperty("THOROUGHFARE_NAME")
	public void setThoroughfareName(String thoroughfareName) {
		this.thoroughfareName = thoroughfareName;
	}

	/**
	 * @return the doubleDependentLocality
	 */
	public String getDoubleDependentLocality() {
		return doubleDependentLocality;
	}

	/**
	 * @param doubleDependentLocality the doubleDependentLocality to set
	 */
	@JsonProperty("DOUBLE_DEPENDENT_LOCALITY")
	public void setDoubleDependentLocality(String doubleDependentLocality) {
		this.doubleDependentLocality = doubleDependentLocality;
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
	@JsonProperty("DEPENDENT_LOCALITY")
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
	@JsonProperty("POST_TOWN")
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
	@JsonProperty("POSTCODE")
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
	@JsonProperty("PO_BOX_NUMBER")
	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	/**
	 * @return the rpc
	 */
	public String getRpc() {
		return rpc;
	}

	/**
	 * @param rpc the rpc to set
	 */
	@JsonProperty("RPC")
	public void setRpc(String rpc) {
		this.rpc = rpc;
	}

	/**
	 * @return the xCoordinate
	 */
	public double getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @param xCoordinate the xCoordinate to set
	 */
	@JsonProperty("X_COORDINATE")
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public double getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * @param yCoordinate the yCoordinate to set
	 */
	@JsonProperty("Y_COORDINATE")
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	@JsonProperty("STATUS")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the logicalStatusCode
	 */
	public String getLogicalStatusCode() {
		return logicalStatusCode;
	}

	/**
	 * @param logicalStatusCode the logicalStatusCode to set
	 */
	@JsonProperty("LOGICAL_STATUS_CODE")
	public void setLogicalStatusCode(String logicalStatusCode) {
		this.logicalStatusCode = logicalStatusCode;
	}

	/**
	 * @return the classificationCode
	 */
	public String getClassificationCode() {
		return classificationCode;
	}

	/**
	 * @param classificationCode the classificationCode to set
	 */
	@JsonProperty("CLASSIFICATION_CODE")
	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
	}

	/**
	 * @return the classificationCodeDescription
	 */
	public String getClassificationCodeDescription() {
		return classificationCodeDescription;
	}

	/**
	 * @param classificationCodeDescription the classificationCodeDescription to set
	 */
	@JsonProperty("CLASSIFICATION_CODE_DESCRIPTION")
	public void setClassificationCodeDescription(String classificationCodeDescription) {
		this.classificationCodeDescription = classificationCodeDescription;
	}

	/**
	 * @return the localCustodianCode
	 */
	public int getLocalCustodianCode() {
		return localCustodianCode;
	}

	/**
	 * @param localCustodianCode the localCustodianCode to set
	 */
	@JsonProperty("LOCAL_CUSTODIAN_CODE")
	public void setLocalCustodianCode(int localCustodianCode) {
		this.localCustodianCode = localCustodianCode;
	}

	/**
	 * @return the localCustodianCodeDescription
	 */
	public String getLocalCustodianCodeDescription() {
		return localCustodianCodeDescription;
	}

	/**
	 * @param localCustodianCodeDescription the localCustodianCodeDescription to set
	 */
	@JsonProperty("LOCAL_CUSTODIAN_CODE_DESCRIPTION")
	public void setLocalCustodianCodeDescription(String localCustodianCodeDescription) {
		this.localCustodianCodeDescription = localCustodianCodeDescription;
	}

	/**
	 * @return the postalAddressCode
	 */
	public String getPostalAddressCode() {
		return postalAddressCode;
	}

	/**
	 * @param postalAddressCode the postalAddressCode to set
	 */
	@JsonProperty("POSTAL_ADDRESS_CODE")
	public void setPostalAddressCode(String postalAddressCode) {
		this.postalAddressCode = postalAddressCode;
	}

	/**
	 * @return the postalAddressCodeDescription
	 */
	public String getPostalAddressCodeDescription() {
		return postalAddressCodeDescription;
	}

	/**
	 * @param postalAddressCodeDescription the postalAddressCodeDescription to set
	 */
	@JsonProperty("POSTAL_ADDRESS_CODE_DESCRIPTION")
	public void setPostalAddressCodeDescription(String postalAddressCodeDescription) {
		this.postalAddressCodeDescription = postalAddressCodeDescription;
	}

	/**
	 * @return the blpuStateCode
	 */
	public String getBlpuStateCode() {
		return blpuStateCode;
	}

	/**
	 * @param blpuStateCode the blpuStateCode to set
	 */
	@JsonProperty("BLPU_STATE_CODE")
	public void setBlpuStateCode(String blpuStateCode) {
		this.blpuStateCode = blpuStateCode;
	}

	/**
	 * @return the blpuStateCodeDescription
	 */
	public String getBlpuStateCodeDescription() {
		return blpuStateCodeDescription;
	}

	/**
	 * @param blpuStateCodeDescription the blpuStateCodeDescription to set
	 */
	@JsonProperty("BLPU_STATE_CODE_DESCRIPTION")
	public void setBlpuStateCodeDescription(String blpuStateCodeDescription) {
		this.blpuStateCodeDescription = blpuStateCodeDescription;
	}

	/**
	 * @return the topographyLayerToid
	 */
	public String getTopographyLayerToid() {
		return topographyLayerToid;
	}

	/**
	 * @param topographyLayerToid the topographyLayerToid to set
	 */
	@JsonProperty("TOPOGRAPHY_LAYER_TOID")
	public void setTopographyLayerToid(String topographyLayerToid) {
		this.topographyLayerToid = topographyLayerToid;
	}

	/**
	 * @return the parentUprn
	 */
	public String getParentUprn() {
		return parentUprn;
	}

	/**
	 * @param parentUprn the parentUprn to set
	 */
	@JsonProperty("PARENT_UPRN")
	public void setParentUprn(String parentUprn) {
		this.parentUprn = parentUprn;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	@JsonProperty("LAST_UPDATE_DATE")
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	@JsonProperty("ENTRY_DATE")
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the blpuStateDate
	 */
	public String getBlpuStateDate() {
		return blpuStateDate;
	}

	/**
	 * @param blpuStateDate the blpuStateDate to set
	 */
	@JsonProperty("BLPU_STATE_DATE")
	public void setBlpuStateDate(String blpuStateDate) {
		this.blpuStateDate = blpuStateDate;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	@JsonProperty("LANGUAGE")
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the match
	 */
	public double getMatch() {
		return match;
	}

	/**
	 * @param match the match to set
	 */
	@JsonProperty("MATCH")
	public void setMatch(double match) {
		this.match = match;
	}

	/**
	 * @return the matchDescription
	 */
	public String getMatchDescription() {
		return matchDescription;
	}

	/**
	 * @param matchDescription the matchDescription to set
	 */
	@JsonProperty("MATCH_DESCRIPTION")
	public void setMatchDescription(String matchDescription) {
		this.matchDescription = matchDescription;
	}
}
