package mediaRentalManager;


/*
 * Class that implements the Media interface to create album objects
 */
public class Album implements Media, Comparable<Media> {
	
	private String title;
	private int copiesAvailable;
	private String artist;
	private String songs;
	
	
	/**
	 * Constructor that initializes an album
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs
	 */
	public Album (String title, int copiesAvailable, String artist, String songs) {
		
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.artist = artist;
		this.songs = songs;
		
	}
	
	
	/**
	 * Returns the title of an album
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	
	/**
	 * Returns the songs in an album
	 * @return
	 */
	public String getSongs() {
		return songs;
	}
	
	
	/**
	 * Returns the artist of an album
	 * @return
	 */
	public String getArtist() {
		return artist;
	}
	
	
	/**
	 * Returns the amount of copies available for an album
	 * @return 
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	
	
	/**
	 * Returns the title of an album (Used for convenience of ArrayList class's toString)
	 * @return
	 */
	public String toString() {
		return title;
	}
	
	
	/**
	 * Decreases the amount of copies of an album
	 */
	public void decreaseCopies() {
		copiesAvailable--;
	}
	
	
	/**
	 * Increases the amount of copies of an album
	 */
	public void increaseCopies() {
		copiesAvailable++;
	}
	
	
	/**
	 * Returns the information of an album 
	 * @return
	 */
	public String toString2() {
		StringBuffer albumInfo = new StringBuffer("Title: " + title + ", ");
		albumInfo.append("Copies Available: " + copiesAvailable + ", ");
		albumInfo.append("Artist: " + artist + ", " + "Songs: " + songs + "\n");
		return albumInfo.toString();
	}
}
