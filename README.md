# zipcode-range-service

Java application to merge the overlapping ZIP code ranges.

# PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

 NOTES
- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

 EXAMPLES:

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]

# Prerequisites
1. Java 8
2. Maven 2.4
3. Eclipse

# Installation Details
1. Java - https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html
2. Maven - https://www.baeldung.com/install-maven-on-windows-linux-mac
3. Eclipse - https://www.eclipse.org/downloads/packages/installer

 # Input Assumption
 Assuming input string should be like [94133,94133] [94200,94299] [94226,94399]
 
 # Steps to run the code from terminal
 1. Download the code from the GIT URL https://github.com/tbommireddi/zipcode-range-service
 2. Goto /zipcode-range-service/target/ folder in the terminal
 3. Run java -jar zipcode-range-service-0.0.1-SNAPSHOT.jar                                                                     
    Enter zip code ranges:<enter string of zip code ranges as given below>                                                     
     Ex: Input string should be like [94133,94133] [94200,94299] [94226,94399]
 
 # Steps to run the code from Eclipse
 1. Clone or download the code from the GIT URL https://github.com/tbommireddi/zipcode-range-service
 2. Import the maven project into the eclipse
 3. Right click on the project. Select Run As -> Maven install and build the project.
 4. Run ZipCodeRangeExecutor.java and enter the input as [94133,94133] [94200,94299] [94226,94399]
 
 # Sample output in terminal:
![alt text](https://github.com/tbommireddi/zipcode-range-service/blob/master/SampleOutput.png)

# Sample output in eclipse:
![alt text](https://github.com/tbommireddi/zipcode-range-service/blob/master/Output_Eclipse.png)
