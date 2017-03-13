package collections;

public class Book extends Media{
	private String author;

	public Book(String id, String title, int year, String author) {
		super(id, title, year);
		this.author = author;
		// TODO Auto-generated constructor stub
	}
	
	public String getAuthor(){
		return author;	
	}
	
	public String toString() {
		String tmp = "{";
		tmp += getId() + ", " + getTitle() + ", " + getYear() + ", " + author;
		return tmp + "}";
	}
}
