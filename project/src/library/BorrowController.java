package library;

import java.util.Iterator;

import collections.List;
/**
 * This is a controller for the borrow funkction. It test first if its possible
 * for user to borrow and if its true, then it proceeds to make the borrow.
 * there is a search here for media, it uses the keys to identify them and puts them on display.
 * @author Tom Leonardsson, Murtadha alasadi
 *
 */
public class BorrowController {
	/**
	 * instance variables
	 */
	private LibraryController libraryController;
	private LogInController logInController;
	
	/**
	 * this is the constructor for the class. it has two parameters for
	 * the other controllers which are needed here.
	 * @param libraryController
	 * @param logInController
	 */
	public BorrowController(LibraryController libraryController, LogInController logInController) {
		this.libraryController = libraryController;
		this.logInController = logInController;
	}
	/**
	 * This is a method that test if its possible to borrow a  media,
	 * if its possible, it returns true if its possible, otherwise
	 * it return false. 
	 * @param key
	 * @return return true or false.
	 */
	public boolean canBorrow(String key) {
		return logInController.getUser() != null && libraryController.getMedia(key).avalible;
	}
	/**
	 * this is the method that makes the borrow. Firstly it get the key for
	 * the media and after that goes and puts the media under the specified user.
	 * @param key
	 */
	public void borrow(String key) {
		System.out.println(libraryController.getMedia(key));
		logInController.getUser().borrow(libraryController.getMedia(key));
		libraryController.getMedia(key).avalible = false;
	}
	
	/**
	 * check if media exists
	 * @return if it exists
	 */
	public boolean mediaExists(String key) {
		return libraryController.getMedia(key) != null;
	}
	
	/**
	 * this is a search engine for the list of the media. 
	 * after you type a certain key, and loops the whole list, and delete 
	 * all the media that doesnt match the the key.
	 * @param search
	 * @param t
	 */
	public void searchList(String search, java.awt.List t) {
		t.removeAll();
		
		Iterator iter = libraryController.getMediaList();
	
		while(iter.hasNext()) {
			String n = iter.next().toString();
			if(n.contains(search)) {
				t.add(n);
			}
		}
	}
}
