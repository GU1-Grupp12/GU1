package library;
/**
 * this the window for the borrowed function.
 * @author Tom Leonardsson, Murtadha Alasadi
 *
 */
public class BorrowedController {
	/**
	 * instance veriables
	 */
	private LogInController logInController;
	private LibraryController libraryController;
	/**
	 * the constructor for the class
	 * @param libraryController
	 * @param logInController
	 */
	public BorrowedController(LibraryController libraryController, LogInController logInController) {
		this.logInController = logInController;
		this.libraryController = libraryController;
	}
	/**
	 * this the method that return a certain media. it uses the key which is 
	 * a parameter. it gets the user that wants to return the media. when its find, its sets 
	 * the availability for the media.
	 * @param key 
	 */
	public void returnMedia(String key) {
		for(int i = 0; i < logInController.getUser().getBorrowedMedia().size(); i++) {
			if(logInController.getUser().getBorrowedMedia().get(i).equals(libraryController.getMedia(key))) {
				logInController.getUser().getBorrowedMedia().remove(i);
				libraryController.getMedia(key).avalible = true;
			}
		}
	}
	/**
	 * this method return the list of all the media that a certain user have.
	 * @return return the media as a string.
	 */
	
	public String showList() {
		return logInController.getUser().getBorrowedList();
	}
}
