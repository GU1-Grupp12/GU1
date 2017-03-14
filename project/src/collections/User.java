package collections;

public class User {
	private String id;
	private String name;
	private String phoneNumber;
	
	private List<Media> borrowedMedia;
	
	public User(String id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		
		borrowedMedia = new List<Media>();
	}
	
	public List<Media> getBorrowedMedia() {
		return borrowedMedia;
	}
	
	public String toString() {
		return "{" + id + ", " + name + ", " + phoneNumber + "}";
	}
}
