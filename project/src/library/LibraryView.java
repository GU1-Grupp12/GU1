package library;

import javax.swing.JPanel;

public class LibraryView extends JPanel {
	private LibraryController controller = new LibraryController();
	
	private LogInController logInController = new LogInController(controller);
	private LogInView logInView = new LogInView(logInController);
	
	public LibraryView(LibraryController controller) {
		this.controller = controller;
		
		this.add(logInView);
	}
}
