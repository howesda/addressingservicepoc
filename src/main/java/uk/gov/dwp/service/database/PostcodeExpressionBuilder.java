package uk.gov.dwp.service.database;

import org.apache.commons.lang3.StringUtils;

public class PostcodeExpressionBuilder {
	private static final String POSTCODE_REGEX = "[a-zA-Z]{1,2}\\d{1,2}\\s\\d[a-zA-Z]{2}";

	private String fullExpressionStart;
	private String fullExpressionEnd;
	private String partialExpressionStart;
	private String partialExpressionEnd;

	/**
	 * @param fullStart the text to place at the beginning of a full postcode.
	 * @param fullEnd   the text to place at the end of a full postcode.
	 * @param partialStart the text to place at the beginning of a partial postcode.
	 * @param partialEnd   the text to place at the end of a partial postcode.
	 */
	public void setExpressionTexts(String fullStart, String fullEnd, String partialStart, String partialEnd) {
		fullExpressionStart = fullStart;
		fullExpressionEnd = fullEnd;
		partialExpressionStart = partialStart;
		partialExpressionEnd = partialEnd;
	}

    /**
	 * @param fullOrPartialPostcode a full or partial postcode for which we need to
	 *                              create the appropriate database expression.
	 */
	public String buildPostcodeExpression(String fullOrPartialPostcode) {
		String postcodeExpression = fullOrPartialPostcode;
		// Remove leading spaces, trailing spaces and replace whitespace sequences by a single space
		postcodeExpression = StringUtils.normalizeSpace(postcodeExpression);
		// Expression depends on whether this is a full or partial postcode
		if (postcodeExpression.matches(POSTCODE_REGEX)) {
			postcodeExpression = fullExpressionStart + postcodeExpression + fullExpressionEnd;
		} else {
			postcodeExpression = partialExpressionStart + postcodeExpression + partialExpressionEnd;
		}
		return postcodeExpression;
	}
}
