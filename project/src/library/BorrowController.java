package library;

import java.util.Iterator;

import collections.List;

public class BorrowController {
	private LibraryController libraryController;
	private LogInController logInController;
	
	public BorrowController(LibraryController libraryController, LogInController logInController) {
		this.libraryController = libraryController;
		this.logInController = logInController;
	}
	
	public boolean canBorrow(String key) {
		return logInController.getUser() != null && libraryController.getMedia(key).avalible;
	}
	
	public void borrow(String key) {
		System.out.println(libraryController.getMedia(key));
		logInController.getUser().borrow(libraryController.getMedia(key));
		libraryController.getMedia(key).avalible = false;
	}
	
	public java.awt.List searchList(String search) {
		java.awt.List tmp = new java.awt.List();
		
		Iterator iter = libraryController.getMedia().keys();
	
		while(iter.hasNext()) {
			String n = iter.next().toString();
			if(n.contains(search)) {
				tmp.add(n);
			}
		}
		
		return tmp;
	}
}
