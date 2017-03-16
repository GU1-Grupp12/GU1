package library;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowedView extends JPanel {
	private BorrowedController controller;

	private JButton ret = new JButton("Återlämna");
	private JButton logout = new JButton("Logga ut");

	private JTextArea text = new JTextArea();
	private JTextField id = new JTextField();

	private JPanel btnPan = new JPanel();
	private JPanel view = new JPanel();
	private JPanel viewer = new JPanel();
	

	private JLabel mediaId = new JLabel("ID:");
	private JLabel borrowed = new JLabel("Utlånade:");

	public BorrowedView(BorrowedController controller) {
		this.controller = controller;

		setLayout(new BorderLayout());
		btnPan.setLayout(new GridLayout(10, 0));
		view.setLayout(new GridLayout(0, 2));

		mediaId.setPreferredSize(new Dimension(80, mediaId.getSize().height));
		borrowed.setPreferredSize(new Dimension(80, borrowed.getSize().height));

		ButtonListener l = new ButtonListener();
		ret.addActionListener(l);
		logout.addActionListener(l);
		
		btnPan.add(mediaId);
		btnPan.add(id);
		btnPan.add(ret);
		btnPan.add(logout);

		view.add(borrowed);
		viewer.add(view);
		viewer.add(text, BorderLayout.WEST);

<<<<<<< HEAD

		add(viewer);
//		add(text, BorderLayout.WEST);
		add(btnPan, BorderLayout.EAST);


		this.add(view, BorderLayout.NORTH);
		this.add(text, BorderLayout.WEST);
		this.add(btnPan, BorderLayout.EAST);

=======
		add(viewer);
//		add(text, BorderLayout.WEST);
		add(btnPan, BorderLayout.EAST);
		this.add(view, BorderLayout.NORTH);
		this.add(text, BorderLayout.WEST);
		this.add(btnPan, BorderLayout.EAST);
>>>>>>> origin/master
	}
	
	public void setTextToBorrowedList() {
		text.setText(controller.showList());
	}
	
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ret) {
				controller.returnMedia(id.getText());
				text.setText(controller.showList());
				System.out.println(controller.showList());
			}
			if (e.getSource() == logout) {
				// skriver det när carl är färdig med controllers
			}
		}
	}
}
