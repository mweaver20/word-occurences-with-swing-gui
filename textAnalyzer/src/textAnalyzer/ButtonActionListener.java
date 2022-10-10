package textAnalyzer;

import static java.util.stream.Collectors.toMap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class ButtonActionListener implements ActionListener{

	TextGui tg;

	public ButtonActionListener(TextGui gui) {
		tg = gui;
	}

	public void actionPerformed(ActionEvent e) {
		//setting refrence variables
		String URL = tg.websiteURL.getText();
		String poemTag = tg.HTMLtag.getText();


		//setting Doc object to URL
		Document doc = null;
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException a) {

			a.printStackTrace();
		}

		// parsing document for title, author, and poem and formatting as Strings
		String poem = doc.select(poemTag).text().replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();

		// converting full text string to an array
		String[] words = poem.split(" ");

		// creating a hashmap to store the words and their occurences as key-value pairs
		Map<String, Integer> wordMap = new HashMap<String, Integer>();

		// for loop to count word occurences and add to the hashmap
		for (String word : words) {
			if (!wordMap.containsKey(word))
				wordMap.put(word, 1);
			else
				wordMap.put(word, wordMap.get(word) + 1);
		}

		// Sorting and saving into new hashmap
		Map<String, Integer> sorted = wordMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		// printing out sorted hashmap
		int i = 1;
		for (String key : sorted.keySet()) {
			System.out.println(i + ". " + key + " - " + sorted.get(key));
			i++;
		}
	}
}
