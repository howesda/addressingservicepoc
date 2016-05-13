package uk.gov.dwp.service.database;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class PostcodeBuilder {
	private static final String POSTCODE_REGEX = "[A-Z]{1,2}\\d{1,2}\\s\\d[A-Z]{2}";

	/**
	 * @param fullOrPartialPostcode a full or partial postcode for which we need to
	 *                              create the appropriate database pattern.
	 * @param wildcardSymbol the symbol to use at the start and end of a partial postcode.
	 */
	public ImmutablePair<String, Boolean> buildPostcode(String fullOrPartialPostcode,
														String wildcardSymbol) {
		// Convert to uppercase
		String postcode = fullOrPartialPostcode.toUpperCase();
		// Remove leading spaces, trailing spaces and replace whitespace sequences by a single space
		postcode = StringUtils.normalizeSpace(postcode);
		// Add wildcard symbols around a partial postcode
		boolean fullPostCode = postcode.matches(POSTCODE_REGEX);
		if (!fullPostCode) {
			postcode = wildcardSymbol + postcode + wildcardSymbol;
		}
		return new ImmutablePair<String, Boolean>(postcode, fullPostCode);
	}
}
