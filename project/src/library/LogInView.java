package library;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInView extends JPanel {
	private LogInController controller;
	
	private JButton logIn = new JButton("LOGGA IN");
	
	private JPanel logInField = new JPanel();
	
	private JTextField logInId = new JTextField();
	
	private JLabel logInBoxText = new JLabel("ID: ");
	private JLabel loggedInUserProfile = new JLabel("PROFILE: ");
	
	public LogInView(LogInController controller) {
		this.controller = controller;
		setLayout(new BorderLayout());
		logInField.setLayout(new GridLayout(0, 2));
		logInBoxText.setPreferredSize(new Dimension(80, logInBoxText.getSize().height));
		logInField.add(logInBoxText);
		logInField.add(logInId);
		this.add(logInField, BorderLayout.NORTH);
		this.add(loggedInUserProfile, BorderLayout.CENTER);
		this.add(logIn, BorderLayout.SOUTH);
		ButtonListener l = new ButtonListener();
		logIn.addActionListener(l);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == logIn) {
				controller.attemptLogIn(logInId.getText());
				loggedInUserProfile.setText(controller.getLoggedInProfileText());
			}
		}
	}
}
