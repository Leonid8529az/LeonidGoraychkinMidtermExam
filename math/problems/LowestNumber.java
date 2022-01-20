package math.problems;

import databases.ConnectToMongoDB;
import databases.ConnectToSqlDB;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LowestNumber {
	int expectedLowest = 5;
	int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
	public static void main(String[] args) throws Exception{
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.
		 */
		int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		connectToSqlDB.insertDataFromArrayToSqlTable(array, "tbl_lowestNumber", "SortingNumbers");
		List<String> lowestValue = connectToSqlDB.readDataBase("tbl_lowestNumber", "SortingNumbers");

		System.out.println("Data is reading from the Table (tbl_primenumber) and displaying to the console");
		for(String st:lowestValue){
			System.out.println(st);
		}
	}
	public int lowestYes(int[] thisOne) {
		int low = thisOne[0];
		for (int i = 0; i<thisOne.length; i++) {
			if(thisOne[i] < low) {
				low = thisOne[i];
			}
		}
		return low;
	}

}
