package app;

import java.util.Random;

public class DrawingApp {
	/*
	 * isValidColor
	 */

	private static boolean isValidColor(char color) {

		if (color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == '*' || color == '.')
			return true;

		return false;
	}

	/*
	 * getRectangle
	 */

	public static String getRectangle(int maxRows, int maxCols, char symbol) {

		// Catch the less than 1s and return null
		if ((maxRows < 1) || (maxCols < 1))
			return null;

		// Initialize a string to return
		String s = "";

		// Do the rows and columns of the given symbol
		for (int i = 1; i <= maxRows; i++) {
			for (int j = 1; j <= maxCols; j++) {
				s += symbol;
			}
			// Catch the last empty line otherwise add one to the string
			if (i != maxRows)
				s += "\n";
		}
		return s;
	}

	/*
	 * getRandomColor
	 */

	public static char getRandomColor(Random random) {
		int i = random.nextInt(6);

		// Create the expected cases for 0-5
		if (i == 0)
			return 'R';
		if (i == 1)
			return 'G';
		if (i == 2)
			return 'B';
		if (i == 3)
			return 'Y';
		if (i == 4)
			return '*';
		if (i == 5)
			return '.';
		return '0';
	}

	/*
	 * getHorizontalBars Method
	 */

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		// Initialize String to return and HorizontalBars and counting variable to break the loop
		String s = "";
		int horizontalBar = (maxRows / bars);
		int max = bars;

		// Catch the invalid inputs
		if (!isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3))
			return null;

		if (horizontalBar < 1)
			return null;

		while (max != 0) {

			// Append the results of each bar to s
			s += getRectangle(horizontalBar, maxCols, color1);
			max--;
			if (max == 0)
				break;
			s += "\n";

			// Append the results of each bar to s
			s += getRectangle(horizontalBar, maxCols, color2);
			max--;
			if (max == 0)
				break;
			s += "\n";

			// Append the results of each bar to s
			s += getRectangle(horizontalBar, maxCols, color3);
			max--;
			if (max == 0)
				break;
			s += "\n";

		}

		return s;
	}

	/*
	 * getFlag
	 */

	public static String getFlag(int size, char color1, char color2, char color3) {
		
		//Return null if the size length is < than 3
		if (size < 3) {
			return null;
		}
		// Initialize variables
		String s = "";
		int cols = size * 5;

		// Create the outer loop for each row for the pattern coming down
		for (int i = 1; i <= size; i++) {

			// add color1 first
			s += getRectangle(1, i, color1);

			// for the first and last row add color2 till the end of the columns
			if (i == 1 || i == size)
				s += getRectangle(1, cols - i, color2);

			// add color 3 to the rest
			else {
				s += getRectangle(1, cols - i, color3);
			}
			s += "\n";
		}

		// Create the outer loop for each row for the pattern coming down
		for (int i = 1; i <= size; i++) {

			// add color1 first
			s += getRectangle(1, size + 1 - i, color1);

			// for the first and last row add color2 till the end of the columns
			if (i == 1 || i == size)
			s += getRectangle(1, cols - size + i - 1, color2);

			// add color 3 to the rest
			else {
				s += getRectangle(1, cols - size + i - 1, color3);
			}
			if (i != size)
			s += "\n";
		}

		return s;
	}

	/*
	 * getVerticalBars
	 */

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {

		// Initialize variables
		String s = "";
		int verticalBar = (maxCols / bars);
		int count;

		// Catch the invalid inputs
		if (!isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3))
			return null;

		if (verticalBar < 1)
			return null;

		// Create an outer loop for every row
		for (int i = 1; i <= maxRows; i++) {
			count = 0;

			// Create an inner loop that breaks when max bars are printed
			while (count != bars) {

				// append each color to the string and increment the count and check count
				s += getRectangle(1, verticalBar, color1);
				count++;
				if (count == bars)
					break;

				s += getRectangle(1, verticalBar, color2);
				count++;
				if (count == bars)
					break;

				s += getRectangle(1, verticalBar, color3);
				count++;
			}

			// Add new line to string if its not the last line
			if (i != maxRows)
				s += "\n";
		}
		return s;
	}
	
	public static void main (String[] args) {
		System.out.print(getVerticalBars(12,10,3,'R','G','B'));
	}

}