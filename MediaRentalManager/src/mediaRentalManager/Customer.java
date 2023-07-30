package mediaRentalManager;

import java.util.ArrayList;


/*
 * Class that creates customers who will hold rented and queue medias
 */
public class Customer implements Comparable<Customer> {

	private String name, address, plan;
	private ArrayList<Media> rented, queue;
	static int LIMITED_PLAN = 2;
	private int customerLimit = 0;

	
	/**
	 * Constructor for creating customer objects
	 * @param name
	 * @param address
	 * @param plan
	 */
	public Customer(String name, String address, String plan) {

		this.name = name;
		this.address = address;
		this.plan = plan;

		if (plan.equals("LIMITED")) {
			customerLimit = LIMITED_PLAN;
		}
		rented = new ArrayList<>();
		queue = new ArrayList<>();
	}

	
	/**
	 * Returns the information of a customer
	 * @return
	 */
	public String toString() {
		
		StringBuffer customerInfo = new StringBuffer("Name: " + name + ", ");
		customerInfo.append("Address: " + address + ", ");
		customerInfo.append("Plan: " + plan + "\n");
		customerInfo.append("Rented: " + rented.toString() + "\n");
		customerInfo.append("Queue: " + queue.toString() + "\n");
		return customerInfo.toString();
		
	}

	
	/**
	 * Returns the name of a customer
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * Returns the plan of a customer
	 * @return
	 */
	public String getPlan() {
		return plan;
	}
	
	
	/**
	 * Sets the limit of allowed rentals by a customer wiht a limited plan
	 * @param newLimit
	 */
	public void setLimit(int newLimit) {
		customerLimit = newLimit;
	}

	
	/**
	 * Adds a given title to a customer's queue
	 * @param mediaTitle
	 * @param media
	 * @return false if a request to add a title does not occur
	 */
	public boolean setQueue(String mediaTitle, ArrayList<Media> media) {
		// Check the list
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).getTitle().equals(mediaTitle)) {
				return false;
			}
		}
		// Add the media if not already in queue
		queue.add(mediaName(mediaTitle, media));
		return true;
	}

	
	/**
	 * Removes a given title from a customer's queue
	 * @param mediaTitle
	 * @return false if a request to remove a title does not occur
	 */
	public boolean removeQueue(String mediaTitle) {
		// Check the list
		for (int i = 0; i < queue.size(); i++) {
			// Remove the item from the queue
			if (queue.get(i).getTitle().equals(mediaTitle)) {
				queue.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a String of valid requests while adding them to a customer's rentals
	 * @return
	 */
	public String setRented() {

		StringBuffer renting = new StringBuffer("");

		for (int i = 0; i < queue.size(); i++) {

			if (validRequest(queue.get(i))) {

				renting.append("Sending " + queue.get(i).getTitle());
				renting.append(" to " + this.name + "\n");
				rented.add(queue.get(i));
				queue.remove(i);
				i--;
			}

		}
		return renting.toString();
	}
	
	/**
	 * Returns a customer's media
	 * @param mediaTitle
	 * @return false if a return of a media does not occur
	 */
	public boolean returnMedia(String mediaTitle) {
		
		for (int i = 0; i < rented.size(); i++) {
			if (rented.get(i).getTitle().equals(mediaTitle)) {
				rented.get(i).increaseCopies();
				rented.remove(i);
				return true;
			}
		}
		return false;
	}
	

	/**
	 * Returns the validity of a customer's request based on their plan and copies available for a media
	 * @param media
	 * @return false if a request to add a media is invalid
	 */
	private boolean validRequest(Media media) {

		if (plan.equals("UNLIMITED") && media.getCopiesAvailable() > 0) {
			media.decreaseCopies();
			return true;
		}
		if(plan.equals("LIMITED") && media.getCopiesAvailable() > 0 && customerLimit > 0) {
			media.decreaseCopies();
			customerLimit--;
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns the media object that is associated a given title
	 * @param mediaTitle
	 * @param media
	 * @return 
	 */
	private Media mediaName(String mediaTitle, ArrayList<Media> media) {
		for (Media m : media) {
			if (m.getTitle().equals(mediaTitle)) {
				return m;
			}
		}
		return null;
	}

	
	/**
	 * A compareTo method for sorting customers in alphabetical order
	 * @param customer
	 */
	public int compareTo(Customer customer) {
		return this.name.compareTo(customer.name);
	}
}
