package collections;

public class Book extends Media{
	private String[] authers;

	public Book(String id, String tite, int year, String[] authers) {
		super(id, tite, year);
		this.authers = authers;
		// TODO Auto-generated constructor stub
	}
	public String[] getAuther(){
		return authers;
		
	}

}
