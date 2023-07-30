package tests;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class TestingSupport {
	private static boolean GENERATE_EXPECTED_RESULTS_FILE = false;
	
	private static InputStream NORMAL_INPUT = System.in;
	private static PrintStream NORMAL_OUTPUT = System.out;
	
	/* We use this string to prevent any hardcoding of results. */
	public static final String HARD_CODE_PREVENTION = "END_OF_TEST";

	/**
	 * Redirects associates standard input with specified file.
	 * 
	 * @param fileName
	 */
	public static void redirectStandardInputToFile(String fileName) {
		InputStream myInput = null;
		try {
			myInput = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		System.setIn(myInput);
	}

	/**
	 * Redirects standard output to returned stream. After running a program, call
	 * toString on stream to get output generated by program.
	 * 
	 * @return stream
	 */
	public static ByteArrayOutputStream redirectStandardOutputToByteArrayStream() {
		ByteArrayOutputStream newOutput = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(newOutput);
		System.setOut(printStream);

		return newOutput;
	}

	/**
	 * Restores System.in and System.out.
	 * 
	 * @param filename
	 * @param results
	 * @return
	 */
	public static void restoreStandardIO() {
		System.setIn(NORMAL_INPUT);
		System.setOut(NORMAL_OUTPUT);
	}

	/**
	 * Verifies the file filename has the same contents as that present in the
	 * results string.  The match must be exact.
	 * 
	 * @param filename
	 * @param results
	 * @return
	 */
	public static boolean exactCorrectResults(String filename, String results) {
		String officialResults = "";
		try {
			BufferedReader fin = new BufferedReader(new FileReader(filename));

			String line;
			boolean firstTime = true;
			while ((line = fin.readLine()) != null) {
				if (firstTime) {
					firstTime = false;
					officialResults = line;
				} else {
					officialResults += "\n" + line;
				}
			}

			fin.close();
		} catch (IOException e) {
			System.out.println("File opening failed.");
			return false;
		}

		if (results.equals(officialResults)) {
			return true;
		}

		return false;
	}

	
	/**
	 * Verifies the file filename has the same contents as that present in the
	 * results string.
	 * 
	 * @param filename
	 * @param results
	 * @return
	 */
	public static boolean correctResults(String filename, String results) {
		String officialResults = "";
		try {
			BufferedReader fin = new BufferedReader(new FileReader(filename));

			String line;
			while ((line = fin.readLine()) != null) {
				officialResults += line + "\n";
			}

			fin.close();
		} catch (IOException e) {
			System.out.println("File opening failed.");
			return false;
		}

		results = removeBlanks(results);
		officialResults = removeBlanks(officialResults);

		if (results.equals(officialResults)) {
			return true;
		}

		return false;
	}

	/**
	 * Removes all blank characters in a string.
	 * 
	 * @param src
	 * @return
	 */
	public static String removeBlanks(String src) {
		return normalize(src);
	}

	/**
	 * Removes all blank characters in a string.
	 * 
	 * @param src
	 * @return
	 */
	public static String normalize(String in) {
		StringTokenizer st = new StringTokenizer(in);
		String retVal = new String();

		while (st.hasMoreTokens()) {
			retVal += st.nextToken();
		}

		return retVal;
	}

	/**
	 * Places results in a file if the GENERATE_EXPECTED_RESULTS_FILE flag is set.
	 * 
	 * @param results
	 * @param expectedResultsFilename
	 */
	public static void generateExpectedResultsFile(String results, String expectedResultsFilename) {
		/* Official use only (we used this to generate official result) */
		if (GENERATE_EXPECTED_RESULTS_FILE) {
			String message;
			if (!writeToFile(expectedResultsFilename, results)) {
				message = "File copying failed";
			} else {
				message = expectedResultsFilename + " created";
			}
			JOptionPane.showMessageDialog(null, message);
		}
	}

	/**
	 * Writes a string to a file.
	 * 
	 * @param filename
	 * @param message
	 * @return
	 */
	public static boolean writeToFile(String filename, String message) {
		try {
			FileWriter output = new FileWriter(filename);
			output.write(message);
			output.close();

		} catch (IOException exception) {
			System.out.println("ERROR: Writing to file " + filename + " failed.");
			return false;
		}
		return true;
	}

	/**
	 * Verifies whether two files have the same contents.
	 * 
	 * @param firstFile
	 * @param secondFile
	 * @return
	 */
	public static boolean sameContents(String firstFile, String secondFile) {
		try {
			if (removeBlanks(fileData(firstFile)).equals(removeBlanks(fileData(secondFile)))) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * Returns a string with a file contents.
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String fileData(String fileName) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Scanner fileScanner = new Scanner(bufferedReader);

		while (fileScanner.hasNextLine())
			stringBuffer.append(fileScanner.nextLine());

		fileScanner.close();

		return stringBuffer.toString();
	}

	/**
	 * Makes a copy of a file.
	 * 
	 * @param sourceFileName
	 * @param targetFileName
	 * 
	 * @return
	 */
	public static boolean copyfile(String sourceFileName, String targetFileName) {
		File sourceFile = new File(sourceFileName);

		if (!sourceFile.exists()) {
			System.err.println(sourceFileName + " does not exist.");
			return false;
		}

		try {
			InputStream inputStream = new FileInputStream(sourceFileName);
			OutputStream outputStream = new FileOutputStream(targetFileName);

			int n;
			while ((n = inputStream.read()) != -1) {
				outputStream.write(n);
			}

			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			System.err.println("In copyfile " + e.getMessage());
			return false;
		}

		return true;
	}
}