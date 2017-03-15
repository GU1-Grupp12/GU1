package library;

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
		logInController.getUser().Borrow(libraryController.getMedia(key));
		libraryController.getMedia(key).avalible = false;
	}
}
