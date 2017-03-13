package collections;

public class User {
	private String id;
	private String name;
	private String phoneNumber;
	
	public User(String id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return "{" + id + ", " + name + ", " + phoneNumber + "}";
	}
}
