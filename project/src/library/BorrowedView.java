package library;
import java.awt.*;
import javax.swing.*;


public class BorrowedView extends JPanel {
	private BorrowedController controller;
	
	private JButton ret = new JButton("Återlämna");
	private JButton logout = new JButton("Logga ut");
	
	private JTextArea text = new JTextArea();
	private JTextField id = new JTextField();
	
	private JPanel btnPan = new JPanel();
	
	
	private JLabel mediaId = new JLabel("ID:");
	private JLabel borrowed = new JLabel("Utlånade");
	
	
	public BorrowedView(BorrowedController controller){
		this.controller = controller;
		
		setLayout(new BorderLayout());
		
		mediaId.setPreferredSize(new Dimension(80, mediaId.getSize().height));
		borrowed.setPreferredSize(new Dimension(80, borrowed.getSize().height));
		
		
	}
	


}
