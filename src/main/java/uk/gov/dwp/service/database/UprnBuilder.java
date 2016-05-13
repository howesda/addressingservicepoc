package uk.gov.dwp.service.database;

public class UprnBuilder {
	/**
	 * This method allow us to obtain a string structure from the
	 * variety of different container types used by Camel which
	 * are not visible to the developer.
	 *
	 * The string parameter is simply returned and can be used
	 * in subsequent SQL calls.
	 *
	 * @param uprn
	 *            the unique property reference number.
	 */
	public String buildUprn(String uprn) {
		return uprn;
	}
}
