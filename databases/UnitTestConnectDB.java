package databases;

import design.EmployeeInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class UnitTestConnectDB {

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        EmployeeInfo positionPointer = new EmployeeInfo();
        ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();
        User testUser = new User("Alex","111","01.01.1990");

        @Test
        public void userPropertiesTest() {
        connectToSqlDB.tableForTest("test_table");
        connectToSqlDB.testDataDB(testUser.stID,testUser.stName,testUser.stDOB,"test_table","id","name","date_of_birth");
            try {
                List<User> dataPull = connectToSqlDB.readUserProfileFromSqlTable();
                Assert.assertEquals(testUser.stName, dataPull.get(0).stName);
                Assert.assertEquals(testUser.stID,dataPull.get(0).stID);
                Assert.assertEquals(testUser.stDOB,dataPull.get(0).stDOB);
                System.out.println("User test passed");
            } catch (Exception ex) {
                System.out.println();
            }

        }
        @Test
        public void testQueryExecution() {
            String select = "SELECT * FROM test_table";
            connectToSqlDB.tableForTest("test_table");
            connectToSqlDB.testDataDB(testUser.stID,testUser.stName,testUser.stDOB,"test_table","id","name","date_of_birth");
            try {
                List <String> mario = connectToSqlDB.directDatabaseQueryExecute(select, "id");
                Assert.assertEquals(testUser.stID,mario.get(0));
                System.out.println("Test Query Execution passed");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        @Test
        public void testInsertArray() {
            boolean check = true;
            int[] testArray = {111,444,331,654,887,142,875,256,424};
            connectToSqlDB.insertDataFromArrayToSqlTable(testArray,"quickTestTable","test_numbers");
            try {
                List<String> coolArray = connectToSqlDB.readDataBase("quickTestTable","test_numbers");
                for (int i = 0; i<coolArray.size(); i++) {
                    int first = testArray[i];
                    int second = Integer.valueOf(coolArray.get(i));
                    if (first != second) {
                        check = false;
                    }
                }
                Assert.assertTrue(check);
                System.out.println("Test Insert Array passed");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    @Test
    public void testInsertStringArray() {

        boolean[] check = {false, false, false, false, false};
        String[] testArray = {"Hello", "portion", "corrosion", "factorial", "forward"};
        connectToSqlDB.insertDataFromStringArrayToSqlTable(testArray, "StringTestTable", "test_words");
        try {
            List<String> coolArray = connectToSqlDB.readDataBase("StringTestTable", "test_words");
            for (int i = 0; i < coolArray.size(); i++) {
                String first = testArray[i];
                String second = coolArray.get(i);
                if (first.equals(second)) {
                    check[i] = true;
                }
            }
            for (int i = 0; i < check.length; i++) {
                Assert.assertTrue(check[i]);
            }
            System.out.println("Test Insert String Array passed");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
        @Test
        public void testInsertString() {
            String testWord = "Hello", testWord2 = "World";
            connectToSqlDB.insertDataFromStringToSqlTable(testWord,testWord2,"StringTestTableAgain","test_words_one","test_words_two");
            try {
                List<String> coolArray = connectToSqlDB.readDataBase("StringTestTableAgain","test_words_one");
                List<String> superCoolArray = connectToSqlDB.readDataBase("StringTestTableAgain", "test_words_two");
                    String first = coolArray.get(0);
                    String second = superCoolArray.get(0);
                    Assert.assertEquals(testWord,first);
                    Assert.assertEquals(testWord2,second);
                System.out.println("Test Insert String Array passed");
            } catch (Exception ex) {
                System.out.println(ex);
            }
    }
    @Test
    public void testTableForEmployees() {
            String[] checker = {"employee_id","first_name","last_name","date_of_birth",
                    "job_position","department","sector","location","email_address",
                    "phone_number","salary",};
            String tableName = "test_employee_table";
            connectToSqlDB.tableForEmployees(tableName);
            try {
                List<String> dbFields = connectToSqlDB.directDatabaseQueryExecute("describe test_employee_table", "Field");
                for (int i = 0; i<dbFields.size(); i++) {
                    Assert.assertEquals(checker[i],dbFields.get(i));
                }
            } catch (Exception ex) {

            }
        }
        @Test
        public void testEmployee() {
            String tableName = "test_employee_table";
            String[] columns = {"employee_id","first_name","last_name","date_of_birth",
                    "job_position","department","sector","location","email_address",
                    "phone_number","salary",};
            String[] checker = {"111","Craig","Alab","10.26.1981",
                    "Customer service","Customer service","C","Washington","craigalab@gmail.com",
                    "448-983-2221","60000.0",};
            connectToSqlDB.tableForEmployees(tableName);
            connectToSqlDB.justIncert(111,"Craig","Alab", "10.26.1981","Customer service","Customer service",
                    "C","Washington","craigalab@gmail.com","448-983-2221",60000,tableName, "employee_id",
                    "first_name","last_name", "date_of_birth","job_position","department", "sector",
                    "location", "email_address", "phone_number", "salary");

            try {
                List<List<String>> empCheck = new LinkedList<List<String>>();
                for (int i = 0; i<columns.length;i++) {
                    empCheck.add(connectToSqlDB.readDataBase(tableName,columns[i]));
                }
                for (int i = 0; i<empCheck.size(); i++) {
                    Assert.assertEquals(checker[i],empCheck.get(i).get(0));
                }
                System.out.println("Test Employee Passed");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }


}
