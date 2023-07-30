package tests;

import sysImplementation.Utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	int arrayTest[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int newArray[];
	int emptyArray[] = {};
	StringBuffer newBuffer[];
	StringBuffer oldBuffer[] = { new StringBuffer("Mary"), new StringBuffer("Terrapins"), new StringBuffer("Computer"),
			new StringBuffer("Science"), new StringBuffer("Basketball"), new StringBuffer("Cannabinoid") };
	StringBuffer shortBuffer[] = {new StringBuffer("Baby"),new StringBuffer("Mama")};
	int lowerLimit = 2;
	int upperLimit = 9;
	int length = 5;
	int instances;
	int positions = 3;
	char separator = ',';
	String arrayString;

	@Test
	public void filterMethod() {

		// Assert that is throws IllegalArgument when null
		assertThrows(IllegalArgumentException.class, () -> {
			newArray = Utilities.filter(null, lowerLimit, upperLimit);
		});

		// Assert that is throws IllegalArgument when lower is higher than upper
		assertThrows(IllegalArgumentException.class, () -> {
			newArray = Utilities.filter(arrayTest, upperLimit, lowerLimit);
		});

		// Assert that the values are >= && =<
		newArray = Utilities.filter(arrayTest, lowerLimit, upperLimit);
		for (int idx = 0; idx < newArray.length; idx++) {
			assertTrue((newArray[idx] >= lowerLimit && newArray[idx] <= upperLimit));
		}
	}

	@Test
	public void arrayStringTest() {

		// Assert that it throws IllegallArgument when null
		assertThrows(IllegalArgumentException.class, () -> {
			arrayString = Utilities.getArrayString(null, separator);
		});

		// Assert that it returns the empty string when the array has no elements
		assertEquals(Utilities.getArrayString(emptyArray, separator), "");

		// Assert that it is correctly adding the separators
		arrayString = Utilities.getArrayString(arrayTest, separator);
		assertEquals(arrayString, "1,2,3,4,5,6,7,8,9,10");

	}

	@Test
	public void instancesMethod() {

		// Assert that it throws IllegallArgument when null
		assertThrows(IllegalArgumentException.class, () -> {
			instances = Utilities.getInstances(null, lowerLimit, upperLimit);
		});

		// Assert that it returns 8 when the arrayTest is passed in
		instances = Utilities.getInstances(arrayTest, lowerLimit, upperLimit);
		assertTrue(instances == 8);

	}

	@Test
	public void rotate() {

		// Assert IllegalArgument
		assertThrows(IllegalArgumentException.class, () -> {
			Utilities.rotate(null, true, positions);
		});

		// Test for right Rotation
		Utilities.rotate(arrayTest, false, positions);

		int rotatedRight[] = { 8, 9, 10, 1, 2, 3, 4, 5, 6, 7 };

		for (int idx = 0; idx < arrayTest.length; idx++) {
			assertTrue(rotatedRight[idx] == arrayTest[idx]);
		}

		// Test for left Rotation
		Utilities.rotate(arrayTest, true, positions + 3);

		int rotatedLeft[] = { 4, 5, 6, 7, 8, 9, 10, 1, 2, 3 };

		for (int idx = 0; idx < arrayTest.length; idx++) {
			assertTrue(arrayTest[idx] == rotatedLeft[idx]);
		}
	}

	@Test
	public void stringBufferArray() {

		// Assert IllegalArgument is thrown when the array is null
		assertThrows(IllegalArgumentException.class, () -> {
			newBuffer = Utilities.getArrayStringsLongerThan(newBuffer, length);
		});
		
		//Assert than an empty array is returned when none of the Strings are longer than the length
		newBuffer = Utilities.getArrayStringsLongerThan(shortBuffer, length);
		assertTrue(newBuffer.length == 0);
		
		// Assert that the returned StringBuffer returns the correct StringBuffer array
		newBuffer = Utilities.getArrayStringsLongerThan(oldBuffer, length);
		
		for (int idx = 0; idx < newBuffer.length; idx++) {
			assertTrue(newBuffer[idx].length() > length);
		}
		
	}

}
