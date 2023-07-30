package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mediaRentalManager.*;

public class StudentTests {

	public static void main(String args[]) {

		MediaRentalManager m = new MediaRentalManager();

		m.addCustomer("Albert, Mike", "11 Apple Mount VA", "LIMITED");
		m.addCustomer("Park, Laura", "227 Park Lane DC", "UNLIMITED");
		m.addCustomer("Smith, John", "354 South J Ave MD", "UNLIMITED");
		m.addAlbum("Bad", 2, "Mike J", "Mirror, Far Away");
		m.addMovie("Gone with the Wind", 2, "PG");
		m.addMovie("Jaws", 4, "R");
		m.addAlbum("Journey", 1, "ABBA", "Yesterday, Hello");
		m.addMovie("Mickey", 1, "PG");
		m.addMovie("Rocky", 3, "PG");

		m.addToQueue("Albert, Mike", "Rocky");
		m.addToQueue("Albert, Mike", "Bad");
		m.addToQueue("Albert, Mike", "Journey");
		m.addToQueue("Smith, John", "Jaws");
		m.addToQueue("Smith, John", "Mickey");
		m.addToQueue("Smith, John", "Gone with the Wind");
		
		
		StringBuffer resultsBuffer = new StringBuffer();
		
		ArrayList<String> searchResults = m.searchMedia(null, "PG", null, null);
		resultsBuffer.append("PG Search: " + searchResults);
		
		searchResults = m.searchMedia("Rocky", null, null, null);
		resultsBuffer.append("\nTitle Search: " + searchResults);
		
		searchResults = m.searchMedia(null, null, null, "Far Away");
		resultsBuffer.append("\nSong Search: " + searchResults);
		
		System.out.println(resultsBuffer);
	
	}
}
