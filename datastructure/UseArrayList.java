package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		ArrayList<String> volcanoes = new ArrayList<String>();
		volcanoes.add("Krakatoa");
		volcanoes.add("Vesuvius");
		volcanoes.add("Mauna Loa");
		volcanoes.add("Nevado del Ruiz");
		volcanoes.add("Mount Pinatubo");
		volcanoes.add("Donuts");

		Iterator iterator = volcanoes.iterator();

		while (iterator.hasNext()) {
			Object volcano = iterator.next();
			System.out.println(volcano + " ");
		}
		System.out.println("But donuts are not volcano");
		volcanoes.remove(volcanoes.size()-1);

		for (int i = 0; i <volcanoes.size(); i++) {
			System.out.println(volcanoes.get(i));
		}

		System.out.println("The peek of the arrayLits is " + volcanoes.get(0));


		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		for(int i = 0; i<volcanoes.size(); i++){
			String inItGoes = volcanoes.get(i);
			connectToSqlDB.insertDataFromStringToSqlTable(inItGoes, "volcanos", "volcanoes_names");
		}

	}

}
