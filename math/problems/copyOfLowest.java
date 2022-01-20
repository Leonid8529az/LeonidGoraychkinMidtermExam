package math.problems;

import databases.ConnectToSqlDB;

import java.util.List;

public class copyOfLowest {
    public static void main(String[] args) throws Exception{
        /*
         * Write java solution to find the lowest number from this array.
         * Use one of the databases from mysql or mongodb to store and to retrieve.
         */
        int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
        System.out.println(lowestYes(array));
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

        connectToSqlDB.insertDataFromArrayToSqlTable(array, "tbl_lowestNumber", "column_lowestNumber");
        List<String> lowestValue = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");
        try {
            connectToSqlDB.insertDataFromArrayToSqlTable(array, "tbl_lowestNumber", "column_lowestNumber");
            lowestValue = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Data is reading from the Table (tbl_primenumber) and displaying to the console");
        for(String st:lowestValue){
            System.out.println(st);
        }
    }
    public static int lowestYes(int[] thisOne) {
        int low = thisOne[0];
        for (int i = 0; i<thisOne.length; i++) {
            if(thisOne[i] < low) {
                low = thisOne[i];
            }
        }
        return low;
    }

}


