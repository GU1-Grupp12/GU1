package collections;
/**
 * 
 * Creates an abstact media class that Book and Dvd will extend
 * 
 * @author Carl Zetterberg
 *
 */
public abstract class Media {
	/**
	 * Instans variables
	 */
	private String id;
	private String title;
	
	private int year;
	
	public boolean avalible;
	/**
	 * constructor that takes a id title and year and sets it to available
	 * @param id for the Media object
	 * @param title o the object
	 * @param year that the object was released
	 */
	public Media(String id, String title, int year) { 
		this.id = id;    
		this.title = title;
		this.year = year;
		
		avalible = true;
	} 
	/**
	 * Gets the objects id
	 * 
	 * @return id of the object
	 */
	public String getId() {  
		return id;    
	} 
	/**
	 * Gets the objects year it was released
	 * 
	 * @return year of the object
	 */
	public int getYear(){
		return year;
	}
	/**
	 * Gets the objects title
	 * 
	 * @return title of the object
	 */
	public String getTitle(){
		return title;	
	}
	/**
	 * Compare to objects id 
	 * 
	 * @param obj the object you want to compare with
	 * @return true if the id match , else false
	 */

	public boolean equals( Object obj ) {
		if(obj instanceof Media) {  
			Media media = (Media)obj; 
			return id.equals( media.getId() );  
		}        
		return false;    
	} 
} 
