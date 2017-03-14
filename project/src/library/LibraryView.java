package library;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class LibraryView extends JPanel {
	private LibraryController controller = new LibraryController();
	
	private LogInController logInController = new LogInController(controller);
	private LogInView logInView = new LogInView(logInController);
	
	private BorrowController borrowController = new BorrowController();
	private BorrowView borrowView = new BorrowView(borrowController);
	
	private BorrowedController borrowedController = new BorrowedController();
	private BorrowedView borrowedView = new BorrowedView(borrowedController);	
	
	private JTabbedPane loggedInTabs = new JTabbedPane();
	
	public LibraryView(LibraryController controller) {
		loggedInTabs.add("LÅNA", borrowView);
		loggedInTabs.add("LÄMNA TILLBAMA", borrowedView);
		add(loggedInTabs);
		
		this.controller = controller;
		
		this.add(logInView);
		//loggedInTabs.setVisible(!logInView.isVisible());
	}
}
