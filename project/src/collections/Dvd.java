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
	 * 
	 * @param id
	 * @param tite
	 * @param year
	 * @param actors
	 */
	public Dvd(String id, String tite, int year, String[] actors) {
		super(id, tite, year);
		this.actors = actors;	
	}
	
	public String[] getActors(){
		return actors;
	}
	
	public String toString() {
		String tmp = "{";
		tmp += getId() + ", " + getTitle() + ", " + getYear() + ", ";
		for(int i = 0; i < actors.length; i++)
			tmp += actors[i] + ((i < actors.length-1) ? ", " : "");
		return tmp + "}";
	}
}
