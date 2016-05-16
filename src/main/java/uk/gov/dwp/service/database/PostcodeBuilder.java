package uk.gov.dwp.service.database;

public class PostcodeBuilder {
	/**
	 * @param fullOrPartialPostcode the full or partial postcode.
	 * @param wildcardSymbol the symbol to use at the end of a postcode query.
	 */
	public String buildPostcode(String fullOrPartialPostcode,
								String wildcardSymbol) {
		// Remove all spaces
		String postcode = fullOrPartialPostcode.replaceAll("\\s+", "");
		// Convert to lowercase
		postcode = postcode.toLowerCase();
		// Add the wildcard symbol
		postcode =  postcode + wildcardSymbol;
		return postcode;
	}
}
