package com.zipcode.range.model;

/**
 * Model class of ZIP code.
 * 
 * @author tbommireddy
 *
 */
public class ZipCodeRange {
	
  private int lowerBound;
  private int upperBound;

  /**
   * Constructor to initialize the variables.
   * 
   * @param lowerBound
   * @param upperBound
   */
  public ZipCodeRange(int lowerBound, int upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  /** 
   * Return the lowerBound ZIP code.
   * 
   * @return the lowerBound
   */
  public int getLowerBound() {
    return lowerBound;
  }

  /**
   * Sets the lowerBound ZIP code.
   * 
   * @param lowerBound lowerBound ZIP code
   */
  public void setLowerBound(int lowerBound) {
    this.lowerBound = lowerBound;
  }

  /**
   * Returns the upperBound ZIP code.
   * 
   * @return upperBound ZIP code
   */
  public int getUpperBound() {
    return upperBound;
  }

  /**
   * Sets the upperBound ZIP code.
   * 
   * @param upperBound upperBound ZIP code
   */
  public void setUpperBound(int upperBound) {
    this.upperBound = upperBound;
  }

}
