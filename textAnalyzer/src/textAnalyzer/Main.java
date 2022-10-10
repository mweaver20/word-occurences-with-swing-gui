package textAnalyzer;

import javax.swing.*;

public class Main {

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TextGui frame = new TextGui();
		frame.setVisible(true);
	} //end GUI construction

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				constructGUI();
			}	
		});


	}//end of main method
}
