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
	}

}
