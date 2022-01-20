package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		Queue<String> mcDonaldsLine = new PriorityQueue<String>();
		mcDonaldsLine.add("Customer 1");
		mcDonaldsLine.add("Customer 2");
		mcDonaldsLine.add("Customer 3");
		mcDonaldsLine.add("Customer 4");
		mcDonaldsLine.add("Customer 5");
		mcDonaldsLine.add("Customer 6");

		Iterator iterator = mcDonaldsLine.iterator();
		System.out.println("This is McDonalds line");
		while(iterator.hasNext()) {
			String client =(String) iterator.next();
			System.out.println(client);
		}

		System.out.println("The peek of the line is " + mcDonaldsLine.peek());
		System.out.println("First client made his order");
		mcDonaldsLine.remove();
		System.out.println("The second client made his order too");
		mcDonaldsLine.poll();
		System.out.println("Now the line looks like this");
		Iterator iterator2 = mcDonaldsLine.iterator();
		while(iterator2.hasNext()) {
			String client =(String) iterator2.next();
			System.out.println(client);
		}




	}

}
