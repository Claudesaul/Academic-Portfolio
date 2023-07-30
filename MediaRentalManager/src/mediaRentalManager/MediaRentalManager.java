package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Media> media = new ArrayList<Media>();

	/*
	 * addCustomer
	 */
	public void addCustomer(String name, String address, String plan) {
		customers.add(new Customer(name, address, plan));
	}

	/*
	 * addMovie
	 */
	public void addMovie(String title, int copiesAvailable, String rating) {
		media.add(new Movie(title, copiesAvailable, rating));
	}

	/*
	 * addAlbum
	 */
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		media.add(new Album(title, copiesAvailable, artist, songs));
	}

	public void setLimitedPlanLimit(int value) {
		Customer.LIMITED_PLAN = value;
		
		for (Customer customer : customers) {
			if (customer.getPlan().equals("LIMITED")){
				customer.setLimit(value);
			}
		}
	}

	/*
	 * getAllCustomersInfo
	 */
	public String getAllCustomersInfo() {

		StringBuffer customerInfo = new StringBuffer("***** Customers' Information *****\n");

		// Sort the list first
		Collections.sort(customers);

		for (Customer c : customers) {
			customerInfo.append(c.toString());
		}
		return customerInfo.toString();
	}

	/*
	 * getAllMediaInfo
	 */
	public String getAllMediaInfo() {

		StringBuffer mediaInfo = new StringBuffer("***** Media Information *****\n");

		// Sort the list first
		Collections.sort(media);

		for (Media m : media) {
			mediaInfo.append(m.toString2());
		}
		return mediaInfo.toString();
	}

	/*
	 * addToQueue
	 */
	public boolean addToQueue(String customerName, String mediaTitle) {
		// Find the customer in the list
		for (Customer customer : customers) {
			if (customer.getName().equals(customerName)) {
				return customer.setQueue(mediaTitle, media);
			}
		}
		return false;
	}

	/*
	 * removeFromQueue
	 */
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		// Find the customer in the list
		for (Customer customer : customers) {
			if (customer.getName().equals(customerName)) {
				// Remove the song from the queue
				return (customer.removeQueue(mediaTitle));
			}
		}
		return false;
	}

	/*
	 * processRequests
	 */
	public String processRequests() {

		// Sort the list first
		Collections.sort(customers);

		StringBuffer requests = new StringBuffer("");

		for (Customer customer : customers) {

			requests.append(customer.setRented());
		}
		return requests.toString();
	}

	/*
	 * returnMedia
	 */
	public boolean returnMedia(String customerName, String mediaTitle) {

		for (Customer customer : customers) {

			if (customer.getName().equals(customerName)) {

				return customer.returnMedia(mediaTitle);
			}
		}
		return false;
	}

	/*
	 * searchMedia
	 */
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {

		ArrayList<String> search = new ArrayList<>();

		if (title == null && rating == null && artist == null && songs == null) {
			Collections.sort(media);
			for (Media m : media) {
				search.add(m.getTitle());
			}
			return search;
		}
		
		for (Media m : media) {

			if (m instanceof Movie) {

				Movie movie = (Movie) m;
				
				boolean titleMatch = title == null || movie.getTitle().equals(title);
				boolean ratingMatch = rating == null || movie.getRating().equals(rating);
				

				if (titleMatch && ratingMatch && artist == null && songs == null) {
					search.add(m.getTitle());
				}

			} else {

				Album album = (Album) m;
				
				boolean titleMatch = title == null || album.getTitle().equals(title);
				boolean artistMatch = artist == null || album.getArtist().equals(artist);
				boolean songsMatch = songs == null || album.getSongs().contains(songs);

				if (titleMatch && artistMatch && songsMatch && rating == null) {
					search.add(m.getTitle());
				}

			}

		}
		Collections.sort(search);
		return search;
	}
}
