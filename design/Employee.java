package design;

public interface Employee {
	
	/*Employee is an Interface which contains multiple unimplemented methods.Again few methods
	has been declared in below. you need to brainstorm to add more methods to meet the business requirements.
	*/
	//please read the following method and understand the business requirements of these following methods
	//and then implement these in a concrete class.
	
	//employeeId() will return employee id.
	public int employeeId();
	
	//employeeName() will return employee name
	public String employeeName(String employeeName);
	
	//assignDepartment() will assign employee to departments
    public String assignDepartment(String depatmentAgain);
	
	//calculate employee salary
	public double calculateSalary(int initialSalary);
	
	//employee benefit
	public void benefitLayout();
	public String employeeLastName(String weGetLastName);
	public String position(String theriPos);
	public String sector(String posit);
	public String phone(String justPhone);
	public String email(String superEmail);
	public String location(String local);

}
