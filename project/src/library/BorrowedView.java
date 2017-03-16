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

		add(viewer);
//		add(text, BorderLayout.WEST);
		add(btnPan, BorderLayout.EAST);

	}
	public class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ret) {
				// skriver det när carl är färdig med controllers
			}
			if (e.getSource() == logout) {
				// skriver det när carl är färdig med controllers
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		BorrowedController controller = new BorrowedController();
		BorrowedView bucky = new BorrowedView(controller);
		frame.setTitle("Borrowed");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(bucky);
		frame.setVisible(true);
	}

}
