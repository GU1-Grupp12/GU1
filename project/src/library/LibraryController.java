package library;

import java.io.IOException;

import javax.swing.JPanel;

import collections.ResourceReader;
import collections.Book;
import collections.Dvd;
import collections.Hashtable;
import collections.Media;
import collections.User;
import collections.BinarySearchTree;

/**
 * this is the "main" controller for the whole program. Here is 
 * pretty much every logic and instance for the program to start
 * and load the users and the media.
 * @author Tom Leonardsson
 *
 */
public class LibraryController {
	/**
	 * instance variables.
	 */
	private Hashtable<String, Media> media;
	private BinarySearchTree<String, User> users;
	
	private LogInController logInController;
	
	private LibraryView view;
	
	public LibraryController() {
		loadUsers("data/Lantagare");
		loadMedia("data/Media");
	}
	/**
	 * this is a set-method for instancing the logInCtroller.
	 * @param logInController
	 */
	public void setLogInController(LogInController logInController) {
		this.logInController = logInController;
	}
	/**
	 * this is the get-method, upon call this method returns the main view.
	 * @return view
	 */
	public LibraryView getView() {
		return view;
	}
	/**
	 * a set-method for changing the view if needed.
	 * @param view
	 */
	public void setView(LibraryView view) {
		this.view = view;
	}
	/**
	 * this is a get-method to return the media of type
	 * hashtable.
	 * @return Hashtable
	 */
	public Hashtable<String, Media> getMedia() {
		return media;
	}
	/**
	 * this is a get-method that return the user when called.
	 * @return user
	 */

	public User getLoggedInUser() {
		return logInController.getUser();
	}
	/**
	 * this is a get-method with a key as a parameter. this return the key
	 * of the user when called upon
	 * @param key
	 * @return
	 */
	public User getUser(String key) {
		return users.get(key);
	}
	/**
	 * this a get-method with a key as a parameter. this returns
	 * the key of the media when called upon
	 * @param key
	 * @return return the key
	 */
	
	public Media getMedia(String key) {
		return media.get(key);
	}
	/**
	 * This method is for loading the users to the database. first of all
	 * it as a parameter 'path'. this is the source file where all users
	 * are. it then create a new BinarySearchTree. after that it get the first
	 * value of a user, and then goes into a loop for gathering all the
	 * users in the file. for every information in get, it create 
	 * a new user object. It keeps running till all users are gathered.
	 * there is an IOException, if it couldnt find any user in the file.
	 * @param path
	 */
	
	public void loadUsers(String path) {
		users = new BinarySearchTree<String, User>();
		String[] values = new String[0];
		int counter = 0;
		try {
			values = ResourceReader.getValuesOnLine(path, counter);
			while(values != null) {
				values = ResourceReader.getValuesOnLine(path, counter);
				if(values != null) users.put(values[0], new User(values[0], values[1], values[2]));
				counter += 1;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * this method is for counting how many media there are, and after that
	 * it return the amount of media .
	 * there is an IOException if it couldnt find any media.
	 * @param path
	 * @return return the amount of media there are.
	 */
	
	public int getAmountOfMedia(String path) {
		String[] values = new String[0];
		int counter = 0;
		try {
			values = ResourceReader.getValuesOnLine(path, counter);
			while(values != null) {
				values = ResourceReader.getValuesOnLine(path, counter);
				counter += 1;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return counter;
	}
	/**
	 * this method is just like the one that load all the user, but its for media.
	 * The difference is that is gets how many media there are in the source file.
	 * And here it divide the media into two part, namely dvd and book. it creates 
	 * an object for each one.
	 * @param path
	 */
	
	public void loadMedia(String path) {
		String[] values = new String[0];
		
		int size = getAmountOfMedia(path);
		
		media = new Hashtable<String, Media>(size);
		
		try {
			for(int i = 0; i < size-1; i++) {
				values = ResourceReader.getValuesOnLine(path, i);	
				if(values[0].equals("Dvd")) {
					String[] actors = new String[values.length-4];
					for(int j = 0; j < actors.length; j++) { 
						actors[j] = values[j+4];
					}
					media.put(values[1], new Dvd(values[1], values[2], Integer.parseInt(values[3]), actors));
				} else {
					media.put(values[1], new Book(values[1], values[3], Integer.parseInt(values[4]), values[2]));
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
