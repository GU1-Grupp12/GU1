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
	
	public void searchList(String search, java.awt.List t) {
		t.removeAll();
		
		Iterator iter = libraryController.getMedia().keys();
		
		Iterator iterV = libraryController.getMedia().values();
	
		while(iter.hasNext()) {
			String n = iter.next().toString();
			if(n.contains(search)) {
				t.add(n);
			}
		}
	}
}
