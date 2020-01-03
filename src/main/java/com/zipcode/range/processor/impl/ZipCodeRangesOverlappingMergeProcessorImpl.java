package com.zipcode.range.processor.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.zipcode.range.model.ZipCodeRange;
import com.zipcode.range.processor.ZipCodeRangesOverlappingMargeProcessor;
import com.zipcode.range.validator.ZipCodeRangesValidator;

/**
 * Implementation of ZipCodeRangesOverlappingMergeProcessor.
 * 
 * @author tbommireddy
 *
 */
public class ZipCodeRangesOverlappingMergeProcessorImpl implements ZipCodeRangesOverlappingMargeProcessor {

	/** {@inheritDoc} */
	@Override
	public String mergeOverlappingZipCodeRanges(String zipCodeRanges) {
		String[] zipCodeIntervals = zipCodeRanges.replaceAll("\\[|\\]", "").split(" ");

		List<ZipCodeRange> list = Arrays.stream(zipCodeIntervals).map(string -> convertToZipCodeRange(string))
				.collect(Collectors.toList());

		list.sort((ZipCodeRange z1, ZipCodeRange z2) -> z1.getLowerBound() - z2.getLowerBound());

		return mergeZipCodesUsingStack(list);

	}

	/**
	 * Validate both lower and upper bound ZIP codes and covert to ZipCodeRange.
	 * 
	 * @param zipCodeRange string of ZIP code range
	 * 
	 * @return ZipCodeRange object
	 */
	private ZipCodeRange convertToZipCodeRange(String zipCodeRange) {
		String[] zipCodes = zipCodeRange.split(",");

		ZipCodeRangesValidator.validateZipCodes(zipCodes);

		int lowerBound = Integer.parseInt(zipCodes[0]);
		int upperBound = Integer.parseInt(zipCodes[1]);

		return new ZipCodeRange(lowerBound, upperBound);
	}

	/**
	 * Merge the overlapping ZIP code ranges.
	 * 
	 * @param zipCodeRanges sorted ZIP code range list
	 * 
	 * @return merged ZIP code ranges
	 */
	private String mergeZipcodes(List<ZipCodeRange> zipCodeRanges) {
		List<ZipCodeRange> mergedZipCodeRanges = new ArrayList<>();
		ZipCodeRange zipcode = null;
		for (ZipCodeRange zipcodeInterval : zipCodeRanges) {
			if (zipcode == null)
				zipcode = zipcodeInterval;
			else {
				if (zipcode.getUpperBound() >= zipcodeInterval.getLowerBound()) {
					zipcode.setUpperBound(Math.max(zipcode.getUpperBound(), zipcodeInterval.getUpperBound()));
				} else {
					mergedZipCodeRanges.add(zipcode);
					zipcode = zipcodeInterval;
				}
			}
		}
		mergedZipCodeRanges.add(zipcode);
		return mergedZipCodeRanges.stream()
				.map(zipCodeRange -> "[" + zipCodeRange.getLowerBound() + "," + zipCodeRange.getUpperBound() + "]")
				.collect(Collectors.joining(" "));
	}

	/**
	 * Merge the overlapping ZIP code ranges.
	 * 
	 * @param zipCodeRanges sorted ZIP code range list
	 * 
	 * @return merged ZIP code ranges
	 */
	private String mergeZipCodesUsingStack(List<ZipCodeRange> zipCodeRanges) {

		Stack<ZipCodeRange> stack = new Stack<>();
		stack.push(zipCodeRanges.get(0));

		for (int i = 1; i < zipCodeRanges.size(); i++) {

			ZipCodeRange currentZipCodeRange = stack.peek();
			ZipCodeRange nextZipCodeRange = zipCodeRanges.get(i);

			if (currentZipCodeRange.getUpperBound() < nextZipCodeRange.getLowerBound()) {
				stack.push(nextZipCodeRange);
			} else if (currentZipCodeRange.getUpperBound() < nextZipCodeRange.getUpperBound()) {
				currentZipCodeRange.setUpperBound(nextZipCodeRange.getUpperBound());
				stack.pop();
				stack.push(currentZipCodeRange);

			}
		}
		return stack.stream()
				.map(zipCodeRange -> "[" + zipCodeRange.getLowerBound() + "," + zipCodeRange.getUpperBound() + "]")
				.collect(Collectors.joining(" "));
	}
}
