package com.zipcode.range.validator;

import java.util.regex.Pattern;

/**
 * 
 * Validator class to validate ZIP code range.
 * 
 * @author tbommireddy
 *
 */
public final class ZipCodeRangesValidator {

	private static final String ZIP_CODE_REG = "^[0-9]{5}$";

	/**
	 * Validate the ZIP codes range is having lower bound and upper bound and should
	 * be 5 digits.
	 * 
	 * @param zipCodes array having lower and upper bound
	 */
	public static void validateZipCodes(String[] zipCodes) {
		if (zipCodes.length != 2) {
			throw new IllegalArgumentException("ZIP codes range should have lower and upper bounds.");
		}

		String lowerBound = zipCodes[0];
		String upperBound = zipCodes[1];

		if ((lowerBound == null || lowerBound.length() == 0 ) || (upperBound == null || upperBound.length() == 0 )) {
			throw new IllegalArgumentException("Lower and upper bound ZIP codes should not be empty.");
		}

		if (!validateZipCode(lowerBound, upperBound)) {
			throw new IllegalArgumentException(
					String.join(" ", "Lower bound:", lowerBound, "upper bound:", upperBound, "should have 5 digits."));
		}

		if (Integer.parseInt(lowerBound) > Integer.parseInt(upperBound)) {
			throw new IllegalArgumentException(String.join(" ", "Lower bound:", lowerBound,
					"should be lesser than upper bound code:", upperBound));
		}

	}

	/**
	 * Returns true if the lower bound and upper bound ZIP codes are numeric and
	 * length is 5.
	 * 
	 * @param lowerBoundZipCode ZIP code to validate
	 * @param upperBoundZipCode ZIP code to validate
	 * 
	 * @return true if the lower bound and upper bound ZIP codes are numeric and
	 *         length is 5, otherwise false
	 */
	private static boolean validateZipCode(String lowerBoundZipCode, String upperBoundZipCode) {
		return Pattern.matches(ZIP_CODE_REG, lowerBoundZipCode) && Pattern.matches(ZIP_CODE_REG, upperBoundZipCode);
	}

}
