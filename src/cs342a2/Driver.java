package cs342a2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String args[]) throws Exception {

		/**
		 * Use Buffered Reader to read the file.
		 */
		BufferedReader file = null;
		String fileName = "pg174.txt";

		try {
			file = new BufferedReader(new FileReader(new File(Driver.class.getResource(fileName).getFile())));
			System.out.println("File: " + fileName);
			System.out.println();

		} catch (Exception e) {
			System.out.println("Error");
			return;
		}

		LinkedList list = new LinkedList();
		Scanner scanner = new Scanner(file);

		/**
		 * Insert the node in each word.
		 */
		while (scanner.hasNext()) {
			String line = scanner.nextLine();

			if (!line.equals("")) {
				String words[] = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s");
				for (int i = 0; i < words.length; i++) {
					if (words[i].length() > 0) {
						list.insertNode(words[i]);
					}
				}
			}
		}
		scanner.close();

		Node wordPortrait = null;
		Node wordPersian = null;
		Node wordDorian = null;
		Node wordExperimental = null;
		Node wordMagnetic = null;

		ArrayList<Node> wordsMoreThan20 = new ArrayList<Node>();

		int maxFrequence = 0;
		Node wordMostFrequently = null;

		int longestLength = 0;
		Node wordLongest = null;

		Node wordBeforeIrritating = null;

		Node node = list.head();

		/**
		 * Find the specific word in the linked list.
		 */
		while (node != null) {

			switch (node.element()) {
			case "portrait":
				wordPortrait = node;
				break;
			case "persian":
				wordPersian = node;
				break;
			case "dorian":
				wordDorian = node;
				break;
			case "experimental":
				wordExperimental = node;
				break;
			case "magnetic":
				wordMagnetic = node;
				break;
			}
			
			/**
			 * Find the word appears more than 20 times.
			 */
			if (node.count() > 20) {
				wordsMoreThan20.add(node);
			}
			
			/**
			 * Find the word appears most frequently.
			 */
			if (node.count() > maxFrequence) {
				maxFrequence = node.count();
				wordMostFrequently = node;
			}

			/**
			 * Find the longest word.
			 */
			if (node.element().length() > longestLength) {
				longestLength = node.element().length();
				wordLongest = node;
			}
			
			/**
			 * Find the word after the "irritating".
			 */
			if (node.next() != null && node.next().element().equals("irritating")) {
				wordBeforeIrritating = node;
			}

			node = node.next();
		}

		/**
		 * Print the result out.
		 */
		System.out.println("1.a. 'portrait'     appears " + (wordPortrait != null ? wordPortrait.count() : 0)
				+ " times in the text.");
		System.out.println("  b. 'persian'      appears " + (wordPersian != null ? wordPersian.count() : 0)
				+ " times in the text.");
		System.out.println(
				"  c. 'dorian'       appears " + (wordDorian != null ? wordDorian.count() : 0) + " times in the text.");
		System.out.println("  d. 'experimental' appears " + (wordExperimental != null ? wordExperimental.count() : 0)
				+ " times in the text.");
		System.out.println("  e. 'magnetic'     appears " + (wordMagnetic != null ? wordMagnetic.count() : 0)
				+ " times in the text.");
		System.out.println();
		System.out.println("2. Therer are " + list.getLength() + " entries in the Linked List.");
		System.out.println();
		System.out.println("3. The following words occur more than 20 times:");

		for (int i = 0; i < wordsMoreThan20.size(); i++) {
			System.out.println("    " + wordsMoreThan20.get(i).element() + " occurs " + wordsMoreThan20.get(i).count()
					+ " times.");
		}

		System.out.println();

		System.out.println("4. '" + (wordMostFrequently != null ? wordMostFrequently.element() : "")
				+ "' occurs most frequently.");

		System.out.println();

		System.out
				.println("5. '" + (wordLongest != null ? wordLongest.element() : "") + "' is the longest in the book.");

		System.out.println();

		System.out.println("6. '" + (wordBeforeIrritating != null ? wordBeforeIrritating.element() : "")
				+ "' occurs before the word 'irritating' (in the linked list).");

	}
}
