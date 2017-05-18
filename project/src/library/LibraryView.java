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

/**
 * Main view for the program
 * @author tom.leonardsson
 *
 */
public class LibraryView extends JPanel {
	private LibraryController controller;
	
	private LogInController logInController;
	private LogInView logInView;
	
	private BorrowController borrowController;
	private BorrowView borrowView;
	
	private BorrowedController borrowedController;
	private BorrowedView borrowedView;	
	
	private JTabbedPane loggedInTabs = new JTabbedPane();
	
	private JButton accept = new JButton("Fortästt");
	
	private JButton logOut = new JButton("Logga Ut");
	
	/**
	 * Create the view and add all components and other views with a specifc controller
	 * @param controller the specfic controller to control the program with
	 */
	public LibraryView(LibraryController controller) {
		this.controller = controller;
		
		logInController = new LogInController(controller);
		logInView = new LogInView(logInController);
		
		borrowController = new BorrowController(controller, logInController);
		borrowView = new BorrowView(borrowController);
		
		borrowedController = new BorrowedController(controller, logInController);
		borrowedView = new BorrowedView(borrowedController);	
		
		controller.setLogInController(logInController);
		
		loggedInTabs.add("LÅNA", borrowView);
		loggedInTabs.add("LÄMNA TILLBAMA", borrowedView);
		add(logOut);
		logOut.setVisible(false);
		add(loggedInTabs);
		ButtonListener l = new ButtonListener();
		logOut.addActionListener(l);
		accept.addActionListener(l);
		logInView.add(accept, BorderLayout.EAST);
		
		this.add(logInView);
		loggedInTabs.setVisible(false);
		
		loggedInTabs.addChangeListener(new ChangeListener() {
			/**
			 * Listen for when the user swithces tabs and update the JTextArea that shows borrowed media
			 * @param arg0
			 */
			public void stateChanged(ChangeEvent arg0) {
				borrowedView.setTextToBorrowedList();
			}
	    });
	}
	
	/**
	 * Button listner
	 * @author tom.leonardsson
	 *
	 */
	private class ButtonListener implements ActionListener {
		/**
		 * Check for when the user presses accept after logging in to hide the log in view and show the logged in view
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == accept) {
				if(controller.getLoggedInUser() != null) {
					logInView.setVisible(false);
					loggedInTabs.setVisible(true);
					logOut.setVisible(true);
					borrowedView.setTextToBorrowedList();
				}
			}
			
			if(e.getSource() == logOut) {
				logInView.setVisible(true);
				loggedInTabs.setVisible(false);
				logOut.setVisible(false);
			}
		}
	}
}
