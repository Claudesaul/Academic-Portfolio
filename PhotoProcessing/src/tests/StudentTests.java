package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sysutilities.Address;

public class StudentTests {

	@Test
	public void constructor4Params() {

		// Constructor with street, city, state, zipcode
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		output += location1;
		assert (output.equals("11800 Trolley Ln Beltsville MD 20705"));

	}
	
	@Test
	public void par4() {
		Address add = new Address("8223 Paint Branch Dr.","College Park", "MD", "20742");
		System.out.println(add);
		assertEquals("8223 Paint Branch Dr. College Park MD 20742", add);
	}

	@Test
	public void defaultConstructor() {

		// Default Constructor
		String output = "";
		Address location2 = new Address();
		output += location2;
		assert (output.equals("8223 Paint Branch Dr. College Park MD 20742"));
	}

	@Test
	public void copyConstructor() {

		// Copy Constructor
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		Address location3 = new Address(location1);
		output += location3;
		assert (output.equals("11800 Trolley Ln Beltsville MD 20705"));
	}

	@Test
	public void streetConstructor() {

		// Constructor with street
		String output = "";
		Address location4 = new Address("1600 Pennsylvania Avenue NW");
		output += location4;
		assert (output.equals("1600 Pennsylvania Avenue NW College Park MD 20742"));
	}

	@Test
	public void getSreet() {

		// getStreet
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		output += location1.getStreet();
		assert (output.equals("11800 Trolley Ln"));
	}

	@Test
	public void getCity() {

		// getCity
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		output += location1.getCity();
		assert (output.equals("Beltsville"));

	}

	@Test
	public void getState() {
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		output += location1.getState();
		assert (output.equals("MD"));
	}

	@Test
	public void getZipCode() {
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		output += location1.getZipCode();
		assert (output.equals("20705"));

	}

	@Test
	public void equals() {
		String output = "";
		Address location1 = new Address("11800 Trolley Ln", "Beltsville", "MD", "20705");
		Address location2 = new Address();
		output += location1.equals(location2);
		assert (output.equals("false"));
	}

}
