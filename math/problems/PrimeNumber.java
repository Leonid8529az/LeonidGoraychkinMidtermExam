package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) throws Exception{
		PrimeNumber primeNumber = new PrimeNumber();
		int[] great = primeNumber.primeNumb();
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		connectToSqlDB.insertDataFromArrayToSqlTable(great, "prime_numbers", "SortingNumbers");
		List<String> lowestValue = connectToSqlDB.readDataBase("prime_numbers", "SortingNumbers");

		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

	}
	public int[] primeNumb() {
		ArrayList<Integer> thisWay = new ArrayList<Integer>();
		boolean primeYes = true;
		int count = 0;
		System.out.print(2 + " ");
		for (int i = 3; i<=1000; i++) {
			for (int j = i-1; j>=2; j--) {
				if (i%j == 0) {
					primeYes = false;
					break;
				}
			}
			if (primeYes == true) {
				thisWay.add(i);
			}
			primeYes = true;


		}
		int[] okay = new int[thisWay.size()];
		for (int i = 0; i<thisWay.size(); i++) {
			okay[i] = thisWay.get(i);
		}
		return okay;
	}

}
