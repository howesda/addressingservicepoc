package uk.gov.dwp.service.database;

import org.apache.commons.lang3.StringUtils;

public class PostcodeBuilder {
	private static final String POSTCODE_VALID_CHARS_REGEX = "^([A-Za-z0-9\\s]*)$";

	/**
	 * @param fullOrPartialPostcode the full or partial postcode.
	 * @param wildcardSymbol the symbol to use at the end of a postcode query.
	 * @throws InvalidPostcodeException if the full or partial postcode is invalid.
	 */
	public String buildPostcode(String fullOrPartialPostcode,
								String wildcardSymbol) throws InvalidPostcodeException {
		// Ensure the incoming data is valid
		if (fullOrPartialPostcode.matches(POSTCODE_VALID_CHARS_REGEX)) {
			// Remove all spaces
			String postcode = fullOrPartialPostcode.replaceAll("\\s+", "");
			// Only proceed if there is at least a single character
			if (!StringUtils.isBlank(postcode)) {
				// Convert to lowercase
				postcode = postcode.toLowerCase();
				// Add the wildcard symbol
				postcode =  postcode + wildcardSymbol;
				return postcode;
			}
		}
		throw new InvalidPostcodeException("Supplied full or partial postcode has invalid format");
	}
}
