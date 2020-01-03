package com.zipcode.range;

import java.util.Scanner;

import com.zipcode.range.processor.ZipCodeRangesOverlappingMargeProcessor;
import com.zipcode.range.processor.impl.ZipCodeRangesOverlappingMergeProcessorImpl;

public class ZipCodeRangeExecutor {

	private static Scanner scan;

	public static void main(String[] args) {
		System.out.println("Enter zip code ranges:");
		scan = new Scanner(System.in);
		String zipCodeRanges = scan.nextLine();
		ZipCodeRangesOverlappingMargeProcessor zipcodeProcessor = new ZipCodeRangesOverlappingMergeProcessorImpl();
		String mergedZipCodeRangesString = zipcodeProcessor.mergeOverlappingZipCodeRanges(zipCodeRanges);

		System.out.println("ZIP Code ranges :" + mergedZipCodeRangesString);

		// [94133,94133] [94200,94299] [94600,94699]
		// [94133,94133] [94200,94299] [94226,94399]
		// [94133,94133] [94226,94399] [94200,94299] [94123,94599]
		// [94133,94133] [94200,94299] [94266,94266] [94600,94699] [94603,94688]
		// [94133,94133] [94200,94288] [94266,94299] [94600,94677] [94603,94688]
		// [94133,94133] [94200,94299] [94600,94699]

	}

}
