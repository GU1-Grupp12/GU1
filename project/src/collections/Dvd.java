package collections;
/**
 * 
 * Creates an Dvd object that extends Media
 * 
 * 
 * @author Carl Zetterberg
 *
 */
public class Dvd extends Media {
	/**
	 * Instans variables
	 */
	private String[] actors;

	/**
	 * Contructor that make a dvd object
	 * @param id of the object
	 * @param tite on the object
	 * @param year the dvd was realesed
	 * @param actors that stared the dvd
	 */
	public Dvd(String id, String tite, int year, String[] actors) {
		super(id, tite, year);
		this.actors = actors;	
	}
	
	/**
	 * Get the actor that stared in the dvd
	 * 
	 * @return and array of the actors
	 */
	public String[] getActors(){
		return actors;
	}
	/**
	 * An toString that decsribes the object
	 * 
	 * @return a string that describes the object
	 */
	public String toString() {
		String tmp = "{";
		tmp += getId() + ", " + getTitle() + ", " + getYear() + ", ";
		for(int i = 0; i < actors.length; i++)
			tmp += actors[i] + ((i < actors.length-1) ? ", " : "");
		return tmp + "}";
	}
}
