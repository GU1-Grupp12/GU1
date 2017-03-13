package collections;

public abstract class Media {
	private String id;
	private String title;
	
	private int year;

	public Media( String id, String title, int year) { 
		this.id = id;    
		this.title = title;
		this.year = year;	
	} 

	public String getId() {  
		return id;    
	} 
	
	public int getYear(){
		return year;
	}
	public String getTitle(){
		return title;	
	}

	public boolean equals( Object obj ) {
		if(obj instanceof Media) {  
			Media media = (Media)obj; 
			return id.equals( media.getId() );  
		}        
		return false;    
	} 
} 
