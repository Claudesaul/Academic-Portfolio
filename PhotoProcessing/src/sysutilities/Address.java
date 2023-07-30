package sysutilities;

public final class Address {

	// Initialize fields
	private final String street, city, state, zip;

	/*
	 * Constructor with street, city, state, zipcode
	 */

	public Address(String street, String city, String state, String zip) {

		// Throw error for illegal arguments
		if (street == null || city == null || state == null || zip == null || !allDigits(zip)) {
			throw new IllegalArgumentException("Invalid Address Argument");
		}

		this.street = street.trim();
		this.city = city.trim();
		this.state = state.trim();
		this.zip = zip.trim();
	}

	/*
	 * Default Constructor
	 */

	public Address() {

		this.street = "8223 Paint Branch Dr.";
		this.city = "College Park";
		this.state = "MD";
		this.zip = "20742";
	}

	/*
	 * Copy Constructor
	 */

	public Address(Address copy) {

		this.street = copy.street;
		this.city = copy.city;
		this.state = copy.state;
		this.zip = copy.zip;
	}

	/*
	 * Constructor with street
	 */

	public Address(String street) {

		this.street = street.trim();
		this.city = "College Park";
		this.state = "MD";
		this.zip = "20742";
	}

	/*
	 * Getters
	 */

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zip;
	}

	/*
	 * equals
	 */

	public boolean equals(Object check) {

		if (check == this) {
			return true;
		}

		if (check == null || getClass() != check.getClass()) {
			return false;
		}

		// Cast the object to an Address object
		Address checkAddress = (Address) check;

		if (street.equals(checkAddress.street) && city.equals(checkAddress.city) && state.equals(checkAddress.state)
				&& zip.equals(checkAddress.zip)) {
			return true;
		}

		return false;
	}

	/*
	 * toString
	 */
	public String toString() {
		return street + " " + city + " " + state + " " + zip;
	}

	/*
	 * All digits Checks a string to make sure all the characters are digits
	 */
	private static boolean allDigits(String zipCode) {

		for (int i = 0; i < zipCode.length(); i++) {
			if (!(Character.isDigit(zipCode.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

}