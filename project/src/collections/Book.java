package collections;

public class Book extends Media{
	private String author;

	public Book(String id, String tite, int year, String author) {
		super(id, tite, year);
		this.author = author;
		// TODO Auto-generated constructor stub
	}
	public String getAuthor(){
		return author;	
	}
}
