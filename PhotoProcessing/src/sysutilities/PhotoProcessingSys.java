package sysutilities;

import javax.swing.JOptionPane;

public class PhotoProcessingSys {

	// Initialize fields
	private String name, transactions;
	private double balance;
	private int transactionsCount;
	private StringBuffer transList = new StringBuffer("Image Transactions\n");
	private Address customerAddress;

	/*
	 * Constructor with name, street, city, state, zipcode
	 */
	public PhotoProcessingSys(String name, String street, String city, String state, String zip) {

		this.name = name;

		try {
			// Create an Address object with the parameters passed in
			customerAddress = new Address(street, city, state, zip);
		} catch (IllegalArgumentException e) {
			customerAddress = new Address();
		}

	}

	/*
	 * Default Constructor
	 */
	public PhotoProcessingSys() {

		this.name = "NONAME";
		customerAddress = new Address();
	}

	/*
	 * toString
	 */
	public String toString() {
		return "Customer Name: " + name + "\n" + "Customer Address: " + customerAddress + "\n" + "Balance: " + balance;
	}

	/*
	 * imageTransaction
	 */
	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode) {

		// Choose graphical mode
		if (graphicalMode) {
			PictureManager.graphicalModeOn();
		} else {
			PictureManager.graphicalModeOff();
		}

		String trans = "";

		// Execute task options
		switch (task) {

		case "display":
			balance++;
			trans += PictureManager.displayPicture(imageName);
			transactionsReturn("Display " + imageName);
			break;

		case "clear":
			balance++;
			trans += PictureManager.clearScreen();
			transactionsReturn("clearScreen");
			break;

		case "displaylast":
			balance++;
			trans += PictureManager.displayLastPicture();
			transactionsReturn("displayLastPicture");
			break;

		case "blackandwhite":
			balance++;
			trans += PictureManager.displayPictureBlackWhitePosterize(imageName, true, false);
			transactionsReturn("displayPictureBlackWhitePosterize: " + imageName + ", " + true + false);
			break;

		case "posterize":
			balance++;
			trans += PictureManager.displayPictureBlackWhitePosterize(imageName, false, true);
			transactionsReturn("displayPictureBlackWhitePosterize: " + imageName + ", " + false + true);
			break;

		case "blackandwhiteposterize":
			balance++;
			trans += PictureManager.displayPictureBlackWhitePosterize(imageName, true, true);
			transactionsReturn("displayPictureBlackWhitePosterize: " + imageName + ", " + true + true);
			break;

		case "selectcolors":

			balance += 2;
			boolean red = trueColor(taskOptions, 'R');
			boolean green = trueColor(taskOptions, 'G');
			boolean blue = trueColor(taskOptions, 'B');
			trans += PictureManager.displayPictureSelectRedGreenBlue(imageName, red, green, blue);
			transactionsReturn("displayPictureSelectRedGreenBlue: " + imageName + ", " + red + green + blue);
			break;

		default:
			trans += "Invalid photoProcessing option";
			transactionsReturn("Invalid photoProcessing option");
		}

		if (graphicalMode) {
			JOptionPane.showMessageDialog(null, "Continue");
		}

		return trans;

	}

	/*
	 * getters
	 */
	public double getBalance() {
		return balance;
	}

	public String getTransactions() {
		return transactions;
	}

	/*
	 * Private method for checking if the colors are present in the taskOptions String
	 * It takes in a String, trims it and converts it to all UpperCase It
	 * checks if the color passed in is anywhere in the string
	 */
	private boolean trueColor(String unfilteredColor, char color) {

		// Make the string shorter to make the loop shorter and ignore the case
		unfilteredColor = unfilteredColor.trim().toUpperCase();

		for (int i = 0; i < unfilteredColor.length(); i++)
			if (unfilteredColor.charAt(i) == (color)) {
				return true;
			}

		return false;
	}

	/*
	 * private method for adding transactions to StringBuffer
	 */
	private void transactionsReturn(String task) {
		transList.append("Transaction #" + ++transactionsCount + ": " + task + "\n");
		transactions = transList.toString();

	}
}