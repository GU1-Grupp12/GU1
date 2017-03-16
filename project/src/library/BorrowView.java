package library;

import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowView extends JPanel {
	private BorrowController controller;

	private JTextField mediaId = new JTextField();
	private JTextField sok = new JTextField();

	private JLabel mId = new JLabel("Media ID: ");
	private JLabel sokf = new JLabel("Sök");

	private List list = new List();

	private JPanel lonField = new JPanel();
	private JPanel btnField = new JPanel();

	private JButton lona = new JButton("Låna");
	private JButton logout = new JButton("logga ut");
	private JButton sokMed = new JButton("Sök");

	public BorrowView(BorrowController controller) {
		this.controller = controller;

		setLayout(new BorderLayout());
		lonField.setLayout(new GridLayout(2, 6));
		btnField.setLayout(new GridLayout(10, 0));

		mId.setPreferredSize(new Dimension(80, mId.getSize().height));
		sokf.setPreferredSize(new Dimension(80, sokf.getSize().height));

		ButtonListener l = new ButtonListener();
		sokMed.addActionListener(l);
		lona.addActionListener(l);
		logout.addActionListener(l);
		
		btnField.add(sokMed);
		btnField.add(lona);
		btnField.add(logout);
		

		sok.setToolTipText("Mata in media-ID");
		mediaId.setToolTipText("Mata in media -ID");

		lonField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lonField.add(sok);
		lonField.add(sokf);
		lonField.add(mediaId);
		lonField.add(mId);

		this.add(btnField, BorderLayout.EAST);
		this.add(lonField, BorderLayout.NORTH);
		this.add(list, BorderLayout.WEST);
	}

	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == sokMed) {
				controller.searchList(sok.getText(), list);
			}
			
			if (e.getSource() == lona) {
				System.out.println(mediaId.getText());
				if(controller.canBorrow(mediaId.getText())) {
					controller.borrow(mediaId.getText());
				}
			}
			if (e.getSource() == logout) {
				// skriver det när carl är färdig med controllers
			}
		}
	}
}
