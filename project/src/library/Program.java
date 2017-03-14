package library;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Program {
	public static void main(String[] args) {
		LibraryController controller = new LibraryController();
		LibraryView viewer = new LibraryView(controller);
		controller.setView(viewer);
		JFrame frame = new JFrame("Biblotek");
		frame.setPreferredSize(new Dimension(640, 480));
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.add(viewer);
		frame.pack();
		frame.setVisible( true );
	}
}
