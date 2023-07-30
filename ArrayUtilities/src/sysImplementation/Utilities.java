package sysImplementation;

public class Utilities {

	/*
	 * filter
	 */
	public static int[] filter(int[] array, int lowerLimit, int upperLimit) {

		// Throw required exceptions when conditions are satisfied
		if ((array == null) || (lowerLimit > upperLimit)) {
			throw new IllegalArgumentException();
		}
		// Declare variables
		int newArrayLength = 0;

		// Loop over the given array to find the new array's length
		for (int idx = 0; idx < array.length; idx++) {
			// Check the lower and upper limits
			if (array[idx] >= lowerLimit && array[idx] <= upperLimit) {
				newArrayLength++;
			}

		}

		// Declare new array to return with the found length and counting variable
		int[] newArray = new int[newArrayLength];
		int count = 0;

		// Populate the new array while iterating over the old array
		for (int idx = 0; idx < array.length; idx++) {
			// Check the lower and upper limits
			if (array[idx] >= lowerLimit && array[idx] <= upperLimit) {
				newArray[count] = array[idx];
				count++;
			}

		}
		return newArray;
	}

	/*
	 * getArrayString
	 */
	public static String getArrayString(int[] array, char separator) {

		// Throw IllegalArgument when the array is null
		if (array == null) {
			throw new IllegalArgumentException();
		}

		// If the array length is 0 return the empty string
		if (array.length == 0) {
			return "";
		}

		StringBuffer arrayString = new StringBuffer("");

		// loop over every index except for the last one
		for (int idx = 0; idx < array.length; idx++) {
			// Add all the indices
			arrayString.append(array[idx]);

			// Add separator except for the last one
			if (idx != array.length - 1) {
				arrayString.append(separator);
			}
		}

		return arrayString.toString();
	}

	/*
	 * getArrayStringsLongerThan
	 */
	public static StringBuffer[] getArrayStringsLongerThan(StringBuffer[] array, int length) {
		
		//throw IllegalArgument if array is null
		if (array == null) {
			throw new IllegalArgumentException();
		}
		
		//Loop to find the indices that meet the length criteria
		int newArrayLength = 0;
		
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx].length() > length) {
				newArrayLength++;
			}
		}
		
		//Return an empty array if none of the indices meet the criteria
		if (newArrayLength == 0) {
			return new StringBuffer[0];
		}
		
		//Create a new StringBuffer array with the count length
		StringBuffer newBuffer[] = new StringBuffer[newArrayLength];
		
		//Loop and populate the new StringBuffer array
		int count = 0;
		
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx].length() > length) {
				newBuffer[count] = new StringBuffer(array[idx]);
				count++;
			}
		}

		return newBuffer;
	}

	/*
	 * getInstances
	 */
	public static int getInstances(int[] array, int lowerLimit, int upperLimit) {

		// Throw the exception if array is null
		if (array == null) {
			throw new IllegalArgumentException();
		}

		int count = 0;

		// loop over the array
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx] >= lowerLimit && array[idx] <= upperLimit) {
				count++;
			}
		}

		return count;
	}

	/*
	 * rotate
	 */
	public static void rotate(int[] array, boolean LeftRotation, int positions) {

		// Throw IllegalArgument when the array is null
		if (array == null) {
			throw new IllegalArgumentException();
		}

		// Check for condition
		if (positions >= 2) {
			// rotate the array using the private method
			for (int i = 1; i <= positions; i++) {
				moveIndex(array, LeftRotation);
			}
		}
	}

	/*
	 * Private method to move indices left or right
	 */
	private static void moveIndex(int[] array, boolean left) {
		int temp;

		// Shift to the left
		if (left) {

			for (int idx = 0; idx < array.length - 1; idx++) {

				temp = array[idx];

				array[idx] = array[idx + 1];

				array[idx + 1] = temp;
			}

		} else {

			// Shift to the right
			for (int idx = array.length - 1; idx > 0; idx--) {

				temp = array[idx];

				array[idx] = array[idx - 1];

				array[idx - 1] = temp;
			}
		}

	}
}
