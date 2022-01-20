package datastructure;

import algorithm.Sort;
import databases.ConnectToSqlDB;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class.
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car.txt";
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\wormi\\IdeaProjects\\midterm-coding-exam\\src\\data\\self-driving-car"));
			String textLine = in.readLine();
			String locomotive = textLine;
			String[] textWords;
			while (textLine != null) {
				System.out.println(textLine);
				textLine = in.readLine();
				locomotive += textLine;
			}
			locomotive = locomotive.replaceAll("\\.", "");
			locomotive = locomotive.replaceAll("\\,", "");
			textWords = locomotive.split(" ");
			connectToSqlDB.insertDataFromStringArrayToSqlTable(textWords,"text_document" ,"words_from_file");
			in.close();
			List<String> allWordsList = new LinkedList<String>();
			Stack<String> everyWordStack = new Stack<String>();
			for (int i = 0; i < textWords.length; i++) {
				allWordsList.add(textWords[i]);
				everyWordStack.push(textWords[i]);
			}
			Iterator iterator = allWordsList.iterator();
			locomotive = (String) iterator.next();
			while (iterator.hasNext()) {
				System.out.println(locomotive);
				locomotive = (String) iterator.next();
			}
			System.out.println(locomotive);
			Iterator iterator2 = everyWordStack.iterator();
			while (iterator2.hasNext()) {
				System.out.println(everyWordStack.pop());
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
		Stack<String> geronimo = new Stack<String>();
		geronimo.push("Item 1");
		geronimo.push("Item 2");
		geronimo.push("Item 3");
		geronimo.push("Item 4");
		geronimo.push("Item 5");
		geronimo.push("Item 6");

		System.out.println("The peek is " + geronimo.peek());
		System.out.println("The first element to escape is " + geronimo.pop());
		System.out.println("I want to find item 4 (" + geronimo.search("Item 4") + ") <- this number" +
				"tells me how far it is from the exit point");


	}
}
