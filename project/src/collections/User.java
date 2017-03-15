package collections;

public class User {
	private String id;
	private String name;
	private String phoneNumber;
	private Media media;
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
	public void setPhoneNumber(String phonenumber){
		this.phoneNumber=phonenumber;
	}
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}

	public void borrow(Media media){
		borrowedMedia.add(media);
		System.out.println(getBorrowedList());
	}
	
	public String getBorrowedList() {
		String tmp = "";
		
		for(int i = 0; i < borrowedMedia.size(); i++)
			tmp += borrowedMedia.get(i).toString() + "\n";
		
		return tmp;
	}
	
	public String toString() {
		return "{" + id + ", " + name + ", " + phoneNumber + "}";
	}
}
