package library;

import javax.swing.JPanel;

public class LibraryView extends JPanel {
	private LibraryController controller = new LibraryController();
	
	private LogInController logInController = new LogInController(controller);
	private LogInView logInView = new LogInView(logInController);
	
	private JPanel mainView = logInView;
	
	public LibraryView(LibraryController controller) {
		this.controller = controller;
		this.add(mainView);
	}
	
	public void setMainView(JPanel mainView) {
		this.mainView = mainView;
	}
}
