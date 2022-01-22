package databases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectToSqlDB {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    public static Properties loadProperties() throws IOException{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public static Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected");
        return connect;
    }

    public List<String> readDataBase(String tableName, String columnName)throws Exception{
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

    private void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connect != null){
                connect.close();
            }
        }catch(Exception e){

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while(resultSet.next()){
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    public void insertDataFromArrayToSqlTable(int [] ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`test_numbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for(int n=0; n<ArrayData.length; n++){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setInt(1,ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertDataFromStringToSqlTable(String ArrayData,String ArrayData2, String tableName, String columnName, String columnName2)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`test_words_one` char(20) DEFAULT NULL,`test_words_two` char(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " +columnName+ "," +columnName2 + " ) VALUES(?,?)");
            ps.setString(1,ArrayData);
            ps.setString(2,ArrayData2);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> directDatabaseQueryExecute(String passQuery,String dataColumn)throws Exception{
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }


    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2)
    {
        try {
            connectToSqlDatabase();
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
                ps.setInt(1,11);
                ps.setString(2,"Jack");

                ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUserProfileFromSqlTable()throws IOException, SQLException, ClassNotFoundException{
        List<User> list = new ArrayList<User>();
        User user = null;
        try{
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM test_table";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next())
            {
                String name = rs.getString("name");
                String id = rs.getString("id");
                String dob = rs.getString("date_of_birth");
                //System.out.format("%s, %s\n", name, id);
                user = new User(name,id, dob);
                list.add(user);

            }
            st.close();
        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }
    public void insertDataFromStringToSqlTable(String ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`words_from_file` char(30) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " +columnName+ " ) VALUES(?)");
            ps.setString(1,ArrayData);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertDataFromStringArrayToSqlTable(String[] ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`ID` int(11) NOT NULL AUTO_INCREMENT,`test_words` char(30) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for(int n=0; n<ArrayData.length; n++){
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setString(1, ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void justIncert(int idData,String nameData,String lastNameData,String dateOfBirth, String jobYes,
                           String departmentYeeeeah,String torSector,String localLoc,
                           String mailE,String numberPhone,double earnEARN, String tableName, String columnName,
                           String columnName2, String columnName3, String columnName4, String columnName5,
                           String columnName6, String columnName7, String columnName8, String columnName9,
                           String columnName10,String columnName11)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+ "," +columnName2+ "," +columnName3+
                    "," +columnName4+"," +columnName5+"," +columnName6+"," +columnName7+"," +columnName8+
                    "," +columnName9+"," +columnName10+","+columnName11+" ) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,idData);
            ps.setString(2,nameData);
            ps.setString(3,lastNameData);
            ps.setString(4,dateOfBirth);
            ps.setString(5,jobYes);
            ps.setString(6,departmentYeeeeah);
            ps.setString(7,torSector);
            ps.setString(8,localLoc);
            ps.setString(9,mailE);
            ps.setString(10,numberPhone);
            ps.setDouble(11,earnEARN);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void tableForEmployees(String tableName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`employee_id` int NOT NULL ,`first_name` char(15) DEFAULT NULL,`last_name` char(20) DEFAULT NULL," +
                    "`date_of_birth` char(10) DEFAULT NULL,`job_position` char(40) DEFAULT NULL,`department` char(30) DEFAULT NULL,`sector` char(1) DEFAULT NULL,`location` char(15) DEFAULT NULL, " +
                    "`email_address` char(30) DEFAULT NULL,`phone_number` char(16),`salary` double DEFAULT NULL,  PRIMARY KEY (`employee_id`) );");
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void tableForBonus(String tableName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`employee_id` int NOT NULL ,`salary` double DEFAULT NULL,`commission` double DEFAULT NULL, `employee_bonus` double DEFAULT NULL,  PRIMARY KEY (`employee_id`) );");
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertDataEmployeeId(int ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
                ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
                ps.setInt(1, ArrayData);
                ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void insertDataDouble(double ArrayData, String tableName, String columnName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( "+columnName+" ) VALUES(?)");
            ps.setDouble(1, ArrayData);
            ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*public List<Integer> readDataBaseInteger(String tableName, String columnName)throws Exception{
        List<Integer> data = new ArrayList<Integer>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

     */
    public void tableForTest(String tableName)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `"+tableName+"`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `"+tableName+"` (`id` char(20) NOT NULL ,`name` char(20) DEFAULT NULL,`date_of_birth` char(20) DEFAULT NULL,  PRIMARY KEY (`id`) );");
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void testDataDB(String ID, String name, String dateOfBirth, String tableName, String columnName, String columnName2, String columnName3)
    {
        try {
            connectToSqlDatabase();
            ps = connect.prepareStatement("INSERT INTO "+tableName+" ( " +columnName+ "," +columnName2+ "," +columnName3+" ) VALUES(?,?,?)");
            ps.setString(1,ID);
            ps.setString(2,name);
            ps.setString(3,dateOfBirth);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertProfileToSqlTable("students", "student_id", "first_name");
//        List<User> list = readUserProfileFromSqlTable();
//        for(User user:list){
//            System.out.println(user.getStName() + " " + user.getStID()+ " " + user.getStDOB());
//        }
//        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
//        List<String> students = connectToSqlDB.readDataBase("student", "name");
//        for (String student: students){
//            System.out.println(student);
//        }


    }
}
