package collections;

public class Dvd extends Media {
	private String[] actors;

	public Dvd(String id, String tite, int year, String[] actors) {
		super(id, tite, year);
		this.actors = actors;	
	}
	
	public String[] getActors(){
		return actors;
		
	}
}
