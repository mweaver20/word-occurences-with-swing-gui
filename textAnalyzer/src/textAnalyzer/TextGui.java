package textAnalyzer;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class TextGui extends JFrame {

	
	//accessed by event listener
	JTextField websiteURL;
	JTextField HTMLtag;
	JButton count;
	JLabel results;

	public TextGui() {
		super();
		init();
	}

	private void init() {
		//frame set up
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Word Occurences");
		this.setLayout(new GridLayout(3, 2));

		//initializing component variables
		JLabel URLlabel  = new JLabel("enter the website URL ");
		JLabel HTMLTagLabel  = new JLabel("enter the contents of desired HTML tag: ");
		websiteURL = new JTextField();
		HTMLtag = new JTextField("for example, enter a p for the paragraph element");
		count = new JButton("Print to console");
		


		//adding frame components
		this.add(URLlabel);
		this.add(websiteURL);
		//second row
		this.add(HTMLTagLabel);
		this.add(HTMLtag);
		//third row
		this.add(new JLabel());
		this.add(count);

		//adding event listener to calculate button
		count.addActionListener(new ButtonActionListener(this));

		this.pack();

	}


}
