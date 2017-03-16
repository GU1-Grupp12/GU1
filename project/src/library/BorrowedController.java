package library;

public class BorrowedController {

	private LogInController logInController;
	private LibraryController libraryController;
	
	public BorrowedController(LibraryController libraryController, LogInController logInController) {
		this.logInController = logInController;
		this.libraryController = libraryController;
	}
	
	public void returnMedia(String key) {
		for(int i = 0; i < logInController.getUser().getBorrowedMedia().size(); i++) {
			if(logInController.getUser().getBorrowedMedia().get(i).equals(libraryController.getMedia(key))) {
				logInController.getUser().getBorrowedMedia().remove(i);
				libraryController.getMedia(key).avalible = true;
			}
		}
	}
	
	public String showList() {
		return logInController.getUser().getBorrowedList();
	}

}
