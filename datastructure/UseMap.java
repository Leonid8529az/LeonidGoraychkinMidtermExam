package datastructure;

import databases.ConnectToSqlDB;

import javax.print.DocFlavor;
import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		List<String> eurasiaCountires = new ArrayList<String>();
		eurasiaCountires.add("Mongolia");
		eurasiaCountires.add("China");
		eurasiaCountires.add("Russia");
		eurasiaCountires.add("Germany");
		eurasiaCountires.add("Great Britain");
		eurasiaCountires.add("France");
		eurasiaCountires.add("Spain");

		List<String> northAmerica = new ArrayList<String>();
		northAmerica.add("USA");
		northAmerica.add("Canada");
		northAmerica.add("Mexico");

		List<String> southAmerica = new ArrayList<String>();
		southAmerica.add("Brazil");
		southAmerica.add("Peru");
		southAmerica.add("Argentine");
		southAmerica.add("Chile");
		southAmerica.add("Brazil");
		southAmerica.add("Colombia");

		List<String> africa = new ArrayList<String>();
		africa.add("Egypt");
		africa.add("Libya");
		africa.add("Sudan");
		africa.add("Chad");
		africa.add("Algeria");
		africa.add("Somali");

		List<String> australia = new ArrayList<String>();
		australia.add("Australia");

		Map<String, List<String>> countries = new LinkedHashMap<String, List<String>>();
		countries.put("Located in Eurasia", eurasiaCountires);
		countries.put("Located in North America", northAmerica);
		countries.put("Located in South America", southAmerica);
		countries.put("Located in Africa", africa);
		countries.put("Located in Australia", australia);

		for (Map.Entry entry : countries.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();
		Iterator<Map.Entry<String, List<String>>> iterator = countries.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, List<String>> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());

		}
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		for (Map.Entry entry : countries.entrySet()) {
			String firstCol = (String) entry.getKey();
			String secondCol = "";
			List<String> dataBaseList = countries.get(firstCol);
			for(int i = 0; i<dataBaseList.size(); i++){
				secondCol = secondCol + dataBaseList.get(i) + " ";
			}
			connectToSqlDB.insertDataFromStringToSqlTable(firstCol, secondCol, "countries", "location","countries_names");
		}
	}

}
