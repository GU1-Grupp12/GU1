package library;

import java.awt.*;
import javax.swing.*;

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
		lonField.setLayout(new GridLayout(2, 2));
		btnField.setLayout(new GridLayout(10, 0));

		mId.setPreferredSize(new Dimension(80, mId.getSize().height));
		sokf.setPreferredSize(new Dimension(80, sokf.getSize().height));

		btnField.add(sokMed);
		btnField.add(lona);
		btnField.add(logout);

		sok.setToolTipText("Mata in media-ID");
		mediaId.setToolTipText("Mata in media -ID");

		lonField.add(sokf);
		lonField.add(sok);
		lonField.add(mId);
		lonField.add(mediaId);

		this.add(btnField, BorderLayout.EAST);
		this.add(lonField, BorderLayout.NORTH);
		this.add(list, BorderLayout.WEST);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		BorrowController controller = new BorrowController();
		BorrowView bucky = new BorrowView(controller);
		frame.setTitle("Borrow");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(bucky);
		frame.setVisible(true);
	}

}
