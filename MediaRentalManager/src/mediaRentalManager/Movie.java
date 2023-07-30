package mediaRentalManager;


/*
 * Class that implements the Media interface to create movie objects
 */
public class Movie implements Media, Comparable <Media> {

	private int copiesAvailable;
	private String title, rating;

	
	/**
	 * Constructor that initializes a Movie
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 */
	public Movie(String title, int copiesAvailable, String rating) {

		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.rating = rating;
	}

	/**
	 * Returns the title of a Movie
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * Returns the amount of copies available for a movie
	 * @return 
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	/**
	 * Returns the rating of a movie
	 * @return
	 */
	public String getRating() {
		return rating;
	}

	
	/**
	 * Returns the title of a movie (Used for convenience of ArrayList class's toString)
	 * @return
	 */
	public String toString() {
		return title;
	}
	
	
	/**
	 * Decreases the amount of copies of a movie
	 */
	public void decreaseCopies() {
		copiesAvailable--;
	}
	
	
	/**
	 * Increases the amount of copies of a movie
	 */
	public void increaseCopies() {
		copiesAvailable++;
	}
	
	
	/**
	 * Returns all the information of a movie
	 * @return
	 */
	public String toString2() {
		StringBuffer movieInfo = new StringBuffer("Title: " + title + ", ");
		movieInfo.append("Copies Available: " + copiesAvailable + ", ");
		movieInfo.append("Rating: " + rating + "\n");
		return movieInfo.toString();
	}
	
}
