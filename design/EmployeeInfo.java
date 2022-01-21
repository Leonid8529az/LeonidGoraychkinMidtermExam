package design;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeInfo extends EmployeeAbstract implements Employee{

	
 /*This class can be implemented from Employee interface then add additional methods in EmployeeInfo class.
 * Also, Employee interface can be implemented into an abstract class.So create an Abstract class
 * then inherit that abstract class into EmployeeInfo class.Once you done with designing EmployeeInfo class,
 * go to FortuneEmployee class to apply all the fields and attributes.
 * 
 * Important: YOU MUST USE the 
 * OOP(abstraction,Encapsulation, Inheritance and Polymorphism) concepts in every level possible.
 * Use all kind of keywords(super,this,static,final........)
 * Implement Nested class.
 * Use Exception Handling.
 *
 */

	/*
	 * declare few static and final fields and some non-static fields
	 */
	public ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
	String goodPer = "Good", veryGoodPer = "Very Good", bestPer = "Best";
	int employeeId;
	String firstName, lastName;
	final String companyName = "ParadiseDuplicate";
	final String developer = "developer", qaTester = "QA Tester", owner = "Business Owner", ba = "Business Analyst",
	managerDevTeam = "DevTeam Manager", managerQATeam = "QA Testers team Manager", techSupport = "Tech support",
	customerService = "Customer service", managerCustomerService = "Customer Service Manager", director = "Director";
	final String aSector = "A", bSector = "B", cSector = "C";
	public String phone, email;
	final String emailPattern ="^[A-Za-z0-9+_.-]{6,25}@[A-Za-z0-9+.-]+\\.[A-Za-z]{2,4}$";
	static int idOfHumans = 110;
	public String positionOfThisGuy, theirLocation, theirDepartment, sectorOver;
	double salary;
	String dateWasBorn = "01.01.1990";
	/*
	 * You must implement the logic for below 2 methods and 
	 * following 2 methods are prototype as well for other methods need to be design,
	 * as you will come up with the new ideas.
	 */
	
	/*
	 * you must have multiple constructor.
	 * Must implement below constructor.
	 */
	public EmployeeInfo(int employeeId){
		this.employeeId = employeeId();
	}
	public EmployeeInfo() {

	}
    public EmployeeInfo(String name, int employeeId){
		
	}
	public EmployeeInfo(String name, String lastName, String position ,String location, String department, int salary) {
		this.employeeId = employeeId();
		this.firstName = employeeName(name);
		this.lastName = employeeLastName(lastName);
		this.positionOfThisGuy = position(position);
		this.theirLocation = location(location);
		this.theirDepartment = assignDepartment(department);
		this.salary = calculateSalary(salary);
	}
	public EmployeeInfo(String name, String lastName, String position ,String location, String department, int salary, String phoneNumber) {
		this.employeeId = employeeId();
		this.firstName = employeeName(name);
		this.lastName = employeeLastName(lastName);
		this.positionOfThisGuy = position(position);
		this.theirLocation = location(location);
		this.theirDepartment = assignDepartment(department);
		this.salary = calculateSalary(salary);
		this.phone = phone(phoneNumber);
	}
	public EmployeeInfo(String name, String lastName, String dateBirth, String position ,String location, String department, int salary, String email, String phoneNumber) {
		this.employeeId = employeeId();
		this.firstName = employeeName(name);
		this.lastName = employeeLastName(lastName);
		this.dateWasBorn = dateBirth;
		this.positionOfThisGuy = position(position);
		this.theirLocation = location(location);
		this.theirDepartment = assignDepartment(department);
		this.sectorOver = sector(this.positionOfThisGuy);
		this.salary = calculateSalary(salary);
		this.email = email(email);
		this.phone = phone(phoneNumber);
		connectToSqlDB.justIncert(this.employeeId,this.firstName,this.lastName, this.dateWasBorn,this.positionOfThisGuy,this.theirDepartment,
				this.sectorOver,this.theirLocation,this.email,this.phone,this.salary,companyName, "employee_id",
				"first_name","last_name", "date_of_birth","job_position","department", "sector",
				"location", "email_address", "phone_number", "salary");

		 
	}



	
	/*
	 * This methods should calculate Employee bonus based on salary and performance.
	 * Then it will return the total yearly bonus. So you need to implement the logic.
	 * Hints: 10% of the salary for best performance, 8% of the salary for average performance and so on. 
	 * You can set arbitrary number for performance.
	 * So you probably need to send 2 arguments.
	 * 
	 */
	public double calculateEmployeeBonus(int numberOfYearsWithCompany, String performace){
		double bonusPercent;
		if (performace.equals("Best")) {
			bonusPercent = 15;
		} else if (performace.equals("Very Good")) {
			bonusPercent = 10;
		} else {
			bonusPercent = 5;
		}
		for (int i = 0; i<numberOfYearsWithCompany; i++) {
			bonusPercent+=5;
		}
		double total=bonusPercent/100;
		return total;
	}
	
	/*
	 * This methods should calculate Employee Pension based on salary and numbers of years with the company.
	 * Then it will return the total pension. So you need to implement the logic.
	 * Hints: pension will be 5% of the salary for 1 year, 10% for 2 years with the company and so on.
	 * 
	 */
	public static int calculateEmployeePension(){
		int total=0;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Please enter start date in format (example: May,2015): ");
		String joiningDate = sc.nextLine();
		System.out.println("Please enter today's date in format (example: August,2017): ");
		String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        //implement numbers of year from above two dates
		//Calculate pension
		return total;
	}

	public int employeeId() {
		idOfHumans++;
		return idOfHumans;
	}

	public String employeeName(String employeeName) {
		String thisIsYourName = employeeName;
		return thisIsYourName;
	}

	public String assignDepartment(String depatmentAgain) {
		String strongDepartment = depatmentAgain;
		return strongDepartment;
	}

	public double calculateSalary(int initialSalary) {
		double strongSalary = (double) initialSalary;
		return strongSalary;
	}

	public void benefitLayout() {

	}

	public String employeeLastName(String weGetLastName) {
		String strongLastName = weGetLastName;
		return strongLastName;
	}

	public String position(String theriPos) {
		String strongPosition = theriPos;
		return strongPosition;
	}

	public String sector(String posit) {
		String strongSector;
		if (posit == owner || posit == ba || posit == director) {
			strongSector = aSector;
		} else if (posit == qaTester || posit == developer || posit == managerDevTeam || posit == managerQATeam) {
			strongSector = bSector;
		} else {
			strongSector = cSector;
		}
		return strongSector;
	}

	public String  phone(String  justPhone) {
		String strongPhone = justPhone;
		return strongPhone;
	}

	public String email(String superEmail) {
		String strongEmail = superEmail;
		return strongEmail;
	}

	public String location(String local) {
		String strongLocation = local;
		return strongLocation;
	}

	static class DateConversion {

		public DateConversion(Months months){}
		public static String convertDate(String date) {
			String [] extractMonth = date.split(",");
			String givenMonth = extractMonth[0];
			int monthDate = whichMonth(givenMonth);
			String actualDate = monthDate + "/" + extractMonth[1];
			return actualDate;
		}

		public static int whichMonth(String givenMonth) {
			Months months = Months.valueOf(givenMonth);
			int date = 0;
			switch (months) {
				case January:
					date = 1;
					break;
				case February:
					date = 2;
					break;
				case March:
					date = 3;
					break;
				case April:
					date = 4;
					break;
				case May:
					date = 5;
					break;
				case June:
					date = 6;
					break;
				case July:
					date = 7;
					break;
				case August:
					date = 8;
					break;
				case September:
					date = 9;
					break;
				case October:
					date = 10;
					break;
				case November:
					date = 11;
					break;
				case December:
					date = 12;
					break;
				default:
					date = 0;
					break;
			}
			return date;

		}
	}

	public static void main(String[] args) {

	}
}
