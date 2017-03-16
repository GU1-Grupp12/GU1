package collections;
/**
 * 
 * Creates an book object that extends Media
 * 
 * 
 * @author Carl Zetterberg
 *
 */
public class Book extends Media{
	/**
	 * Instans variables
	 */
	private String author;
	/**
	 * Constructor that takes some parameters to make a book object
	 * 
	 * @param id the id of the book
	 * @param title of the book
	 * @param year that the book was released
	 * @param author that wrote the book
	 */
	public Book(String id, String title, int year, String author) {
		super(id, title, year);
		this.author = author;
	}
	/**
	 * gets the name of the author of the book
	 * 
	 * @return authors name
	 */
	public String getAuthor(){
		return author;	
	}
	/**
	 *Creates a string that explains the book object 
	 * 
	 * @return a string 
	 */
	public String toString() {
		String tmp = "{";
		tmp += getId() + ", " + getTitle() + ", " + getYear() + ", " + author;
		return tmp + "}";
	}
}
