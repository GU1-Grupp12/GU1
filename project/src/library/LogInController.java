package library;

import javax.swing.JPanel;

import collections.User;

public class LogInController {
	private LibraryController libraryController;
	
	private LogInView view;
	
	public User loggedInUser;
	
	public LogInController(LibraryController libraryController) {
		this.libraryController = libraryController;
		view = new LogInView(this);
	}

	public void attemptLogIn(String key) {
		System.out.println(key);
		if(libraryController.getUser(key) != null) {
			loggedInUser = libraryController.getUser(key);
		}
		else 
			loggedInUser = null;
	}
	
	public String getLoggedInProfileText() {
		if(loggedInUser != null) {
			return "PROFILE: " + loggedInUser.toString();
		} else {
			return "PROFILE: INGEN SÅN ID";
		}
	}
	
	public User getUser() {
		return loggedInUser;
	}
}
