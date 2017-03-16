package library;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * this is the main program of the whole program. this main method starts
 * every action in the program. The only this it does is call for the 
 * controller of the program, and draw a frame for the program.
 * @author Tom Leonardsson
 *
 */

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
