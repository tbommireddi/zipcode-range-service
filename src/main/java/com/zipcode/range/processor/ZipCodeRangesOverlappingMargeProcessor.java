package com.zipcode.range.processor;

/**
 * Interface to merge overlapping ZIP code ranges and return the minimum no of
 * ranges.
 * 
 * @author tbommireddy
 *
 */
public interface ZipCodeRangesOverlappingMargeProcessor {

	/**
	 * Merge overlapping ZIP code ranges.
	 * 
	 * @param zipCodeRanges ZIP code ranges to merge the overlapping ranges
	 * 
	 * @return list of ZIP code ranges
	 */
	String mergeOverlappingZipCodeRanges(String zipCodeRanges);

}
