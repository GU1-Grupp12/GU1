package library;

public class BorrowController {
	private LibraryController libraryController;
	
	public boolean canBorrow(String key) {
		return libraryController.getMedia(key).avalible && libraryController.getLoggedInUser() != null;
	}
}
