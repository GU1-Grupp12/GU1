package library;

import java.awt.*;
import javax.swing.*;

public class BorrowView extends JPanel{
	private BorrowController controller;
	
	private JButton lona = new JButton("Låna");
	private JTextField mediaId = new JTextField();
	private JLabel mId = new JLabel("Media ID: ");
	private List list = new List();
	private JPanel sokField = new JPanel();
	private JTextField sok = new JTextField();
	private JLabel sokf = new JLabel("Sök");
	private JPanel lonField = new JPanel();
	private JFrame frame;
	
	public BorrowView (BorrowController controller){
		this.controller = controller;
		
		
		setLayout(new BorderLayout());
		lonField.setLayout(new GridLayout(0,2));
		sokField.setLayout(new GridLayout(0,2));
		mId.setPreferredSize(new Dimension(80, mId.getSize().height));
		sokf.setPreferredSize(new Dimension(80,sokf.getSize().height));
		
		sokField.add(sok);
		sokField.add(sokf);
		
		lonField.add(mId);
		lonField.add(mediaId);
		frame.add(lonField, BorderLayout.NORTH);
		frame.add(sokField, BorderLayout.NORTH);
		frame.add(list, BorderLayout.WEST);
		frame.add(lona, BorderLayout.CENTER);
		frame.add(lona, BorderLayout.EAST);
		
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Spacebar Invader");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible( true );
	}
	

}
