package mediaRentalManager;

/*
 * Interface that defines the functionality expected from
 * the two types of the media classes(Album, and Movie)
 */
public interface Media extends Comparable <Media> {
	
	
	/**
	 * Returns the title of every media
	 * @return
	 */
	public String getTitle();
	
	
	/*
	 * Returns the amount of copies available associated with a media object
	 * @return 
	 */
	public int getCopiesAvailable();
	
	
	/*
	 * Returns the title of a media (Used for convenience of ArrayList class's toString)
	 * @param 
	 * @return
	 */
	public String toString();
	
	
	/**
	 * Returns the information of a media 
	 * @return
	 */
	public String toString2();
	
	
	/*
	 * Decreases the amount of copies associated with a media by one
	 */
	public void decreaseCopies();
	
	
	/*
	 * Increases the amount of copies associated with a media by one
	 */
	public void increaseCopies();
	
	
	/*
	 * default compareTo method defined for the comparisons of Medias
	 */
	default int compareTo(Media media) {
		return getTitle().compareTo(media.getTitle());
	}
		
}
