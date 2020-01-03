package com.zipcode.range;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.zipcode.range.processor.ZipCodeRangesOverlappingMargeProcessor;
import com.zipcode.range.processor.impl.ZipCodeRangesOverlappingMergeProcessorImpl;

/*
 * Test class to validate ZipCodeRangesMerger.
 */
public class ZipCodeRangeExecutorTest {

	@Test
	public void testZipCodeRangesMergeWithNoOverlappingRanges() {
		String inputDataSet = "[94133,94133] [94200,94299] [94600,94699]";
		ZipCodeRangesOverlappingMargeProcessor zipcodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		String mergedZipCodeRanges = zipcodeMerger.mergeOverlappingZipCodeRanges(inputDataSet);
		assertTrue(mergedZipCodeRanges.equals("[94133,94133] [94200,94299] [94600,94699]"));
	}

	@Test
	public void testZipCodeRangesMergeWithOverlappingRanges() {
		String inputDataSet = "[94133,94133] [94200,94299] [94226,94399]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		String mergedZipCodeRanges = zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet);
		assertTrue(mergedZipCodeRanges.equals("[94133,94133] [94200,94399]"));
	}

	@Test
	public void testZipCodeRangesMergeWithRangeHavingOneZipCodeRange() {
		String inputDataSet = "[92004] [92003,92004]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet));

		assertEquals("ZIP codes range should have lower and upper bounds.", exception.getMessage());
	}

	@Test
	public void testZipCodeRangesMergeWithRangeHavingMoreThanTwoZipCodes() {
		String inputDataSet = "[92004,92002,92003] [92003,92004]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet));

		assertEquals("ZIP codes range should have lower and upper bounds.", exception.getMessage());
	}

	@Test
	public void testZipCodeRangesMergeWithEmptyRange() {
		String inputDataSet = "[] [92003,92004]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet));

		assertEquals("ZIP codes range should have lower and upper bounds.", exception.getMessage());
	}

	@Test
	public void testZipCodeRangesMergeWithInvalidZipCodeLength() {
		String inputDataSet = "[9200,92004]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet));

		assertEquals("Lower bound: 9200 upper bound: 92004 should have 5 digits.", exception.getMessage());
	}
	
	@Test
	public void testZipCodeRangesMergeWithInvalidUpperBoundZipCode() {
		String inputDataSet = "[92000,91004]";
		ZipCodeRangesOverlappingMargeProcessor zipCodeMerger = new ZipCodeRangesOverlappingMergeProcessorImpl();
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> zipCodeMerger.mergeOverlappingZipCodeRanges(inputDataSet));

		assertEquals("Lower bound: 92000 should be lesser than upper bound code: 91004", exception.getMessage());
	}
}
