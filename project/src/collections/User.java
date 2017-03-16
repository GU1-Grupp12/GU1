package collections;

/**
 * An entity class that keeps track of a user
 * @author tom.leonardsson & David Svensson
 *
 */
public class User {
	private String id;
	private String name;
	private String phoneNumber;
	private List<Media> borrowedMedia;
	
	/**
	 * Create user with specifc id, name and phonenumber
	 * @param id the id of the user
	 * @param name the name of the user
	 * @param phoneNumber the phone number of the user
	 */
	public User(String id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		
		borrowedMedia = new List<Media>();
	}
	
	/**
	 * Get the list of what has been borrowed
	 * @return the list of what has been borrowed
	 */
	public List<Media> getBorrowedMedia() {
		return borrowedMedia;
	}
	
	/**
	 * Set the phone number
	 * @param phonenumber
	 */
	public void setPhoneNumber(String phonenumber){
		this.phoneNumber=phonenumber;
	}
	/** 
	 * Get the name of the user
	 * @return the name of the user
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Get the id of the user
	 * @return the id of the user
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Add a media object to the list of borrowed media
	 * @param the media to add
	 */
	public void borrow(Media media){
		borrowedMedia.add(media);
		System.out.println(getBorrowedList());
	}
	
	/**
	 * Get a structured string of the list of media that has been borrowed
	 * @return the strucuterd string
	 */
	public String getBorrowedList() {
		String tmp = "";
		
		for(int i = 0; i < borrowedMedia.size(); i++)
			tmp += borrowedMedia.get(i).toString() + "\n";
		
		return tmp;
	}
	
	/**
	 * Create a structured string of the contents of the user
	 * @return the structured string
	 */
	public String toString() {
		return "{" + id + ", " + name + ", " + phoneNumber + "}";
	}
}
