package library;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class LibraryView extends JPanel {
	private LibraryController controller = new LibraryController();
	
	private LogInController logInController = new LogInController(controller);
	private LogInView logInView = new LogInView(logInController);
	
	private BorrowController borrowController = new BorrowController(controller, logInController);
	private BorrowView borrowView = new BorrowView(borrowController);
	
	private BorrowedController borrowedController = new BorrowedController(controller, logInController);
	private BorrowedView borrowedView = new BorrowedView(borrowedController);	
	
	private JTabbedPane loggedInTabs = new JTabbedPane();
	
	private JButton accept = new JButton("Fortästt");
	
	public LibraryView(LibraryController controller) {
		controller.setLogInController(logInController);
		
		loggedInTabs.add("LÅNA", borrowView);
		loggedInTabs.add("LÄMNA TILLBAMA", borrowedView);
		add(loggedInTabs);
		ButtonListener l = new ButtonListener();
		accept.addActionListener(l);
		logInView.add(accept, BorderLayout.EAST);
		
		this.controller = controller;
		
		this.add(logInView);
		loggedInTabs.setVisible(false);
		
		loggedInTabs.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				borrowedView.setTextToBorrowedList();
			}
	    });
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == accept) {
				if(controller.getLoggedInUser() != null) {
					logInView.setVisible(false);
					loggedInTabs.setVisible(true);
				}
			}
		}
	}
}
