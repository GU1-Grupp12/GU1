package library;

import javax.swing.JPanel;

import collections.User;

/**
 * Control the view of the log-in screen
 * @author tom.leonardsson
 *
 */
public class LogInController {
	private LibraryController libraryController;
	
	private LogInView view;
	
	public User loggedInUser;
	
	/**
	 * Create the controller with a specifc controller
	 * @param libraryController
	 */
	public LogInController(LibraryController libraryController) {
		this.libraryController = libraryController;
		view = new LogInView(this);
	}

	/**
	 * Try to log in with the a specicf key(user id)
	 * @param key the id of the user
	 */
	public void attemptLogIn(String key) {
		System.out.println(key);
		if(libraryController.getUser(key) != null) {
			loggedInUser = libraryController.getUser(key);
		}
		else 
			loggedInUser = null;
	}
	
	/**
	 * generate string that shows the logged in user or an error message if log in fail
	 * @return a string that shows the profile or an error
	 */
	public String getLoggedInProfileText() {
		if(loggedInUser != null) {
			return "PROFILE: " + loggedInUser.toString();
		} else {
			return "PROFILE: INGEN SÅN ID";
		}
	}
	
	/**
	 * Get the currently logged in user
	 * @return the logged in user
	 */
	public User getUser() {
		return loggedInUser;
	}
	
	/**
	 * log out the user
	 */
	public void logOut() {
		loggedInUser = null;
	}
}
