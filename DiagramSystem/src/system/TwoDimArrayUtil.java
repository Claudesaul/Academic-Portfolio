package system;

public class TwoDimArrayUtil {

	/*
	 * appendLeftRight
	 */
	public static char[][] appendLeftRight(char[][] left, char[][] right) {

		// Find the largest of the two arrays
		boolean leftIsLarger = left.length >= right.length;

		// Find the values of both arrays
		int minRows = Math.min(left.length, right.length);
		int maxRows = Math.max(left.length, right.length);

		// Initialize a new 2d char array
		char[][] appendedLR = new char[maxRows][];

		// Combine the arrays
		for (int row = 0; row < minRows; row++) {
			appendedLR[row] = combinedArrays(left[row], right[row]);
		}

		// Add the remaining rows depending on the largest
		if (leftIsLarger) {
			rowCall(appendedLR, left, minRows, true);
		} else {
			rowCall(appendedLR, right, minRows, true);
		}
		return appendedLR;
	}

	/*
	 * appendTopBottom
	 */
	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {

		int combinedLength = top.length + bottom.length;

		// Initialize a new 2d char array
		char[][] appendedTB = new char[combinedLength][];

		// Add the top array, then the bottom array
		rowCall(appendedTB, top, 0, true);
		rowCall(appendedTB, bottom, top.length, false);

		return appendedTB;
	}

	/*
	 * isRagged
	 */
	public static boolean isRagged(char[][] array) {

		// Find the first row length
		int firstRow = array[0].length;

		// Make sure all the other rows are the same length as the first one
		for (int i = 1; i < array.length; i++) {

			if (array[i].length != firstRow) {
				return true;
			}
		}
		return false;
	}

	/*
	 * rotateLeftOneColumn
	 */
	public static void rotateLeftOneColumn(char[][] array) {

		// Throw the expected exception
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException();
		}

		// Loop the given array
		for (int row = 0; row < array.length; row++) {

			// Temporarily hold the first index
			char firstIndex = array[row][0];

			// Shift all the columns over once
			for (int col = 0; col < array[row].length - 1; col++) {

				array[row][col] = array[row][col + 1];
			}
			// Set the last index to the first index
			array[row][array[row].length - 1] = firstIndex;
		}

	}

	/*
	 * rotateTopOneRow
	 */
	public static void rotateTopOneRow(char[][] array) {

		// Throw the expected exception
		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException();
		}

		// Temporarily hold the first row
		char[] firstRow = array[0];

		// Rotate all the rows
		for (int row = 0; row < array.length - 1; row++) {
			array[row] = array[row + 1];
		}
		// Set the last row to the first row
		array[array.length - 1] = firstRow;
	}

	/*
	 * This private method will add any created row to a given 2D array
	 */
	private static void rowCall(char[][] appending, char[][] toAppend, int start, boolean sameRow) {

		// If the array to append is not the same row
		if (sameRow) {
			// Append the remaining rows
			for (int i = start; i < toAppend.length; i++) {
				appending[i] = toAppend[i];
			}
		}
		// If the array to append is not the same row
		else {
			for (int i = 0; i < toAppend.length; i++) {
				appending[start++] = toAppend[i];
			}
		}

	}

	/*
	 * This method returns a combination of two provided arrays
	 */
	private static char[] combinedArrays(char[] array1, char[] array2) {
		// Set a counting variable
		int count = 0;

		// Create an array of characters to return
		char[] combinedArray = new char[array1.length + array2.length];

		// Loop through the first array and add it to the new one
		for (int i = 0; i < array1.length; i++) {
			combinedArray[count++] = array1[i];
		}

		// Loop through the second array and add it to the new one
		for (int i = 0; i < array2.length; i++) {
			combinedArray[count++] = array2[i];
		}

		return combinedArray;
	}

}