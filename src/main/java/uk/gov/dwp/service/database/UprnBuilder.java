package uk.gov.dwp.service.database;

public class UprnBuilder {
	private static final String UPRN_VALID_CHARS_REGEX = "^([0-9]*)$";

	/**
	 * @param uprn
	 *            the unique property reference number.
	 * @throws InvalidUprnException if the unique property reference number is invalid.
	 */
	public String buildUprn(String uprn) throws InvalidUprnException {
		// Ensure the incoming data is valid
		if (!uprn.matches(UPRN_VALID_CHARS_REGEX)) {
			throw new InvalidUprnException("Supplied uprn has invalid format");
		}
		return uprn;
	}
}
