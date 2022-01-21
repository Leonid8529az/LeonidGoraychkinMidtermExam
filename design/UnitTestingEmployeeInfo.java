package design;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

public class UnitTestingEmployeeInfo {
    EmployeeInfo positionPointer = new EmployeeInfo();
    EmployeeInfo employeeTest = new EmployeeInfo("Alfred", "Nuno","03.09.1992", positionPointer.owner,"Washington","Production", 200000, "alfrednuno@gmail.com", "123-123-1234" );
    @Test
    public void testID() {
        Assert.assertEquals(116,employeeTest.employeeId);
        System.out.println("Test Employee Id Passed");
    }
    @Test
    public void testFirstName() {
        boolean correctName = true;
        char[] stone = employeeTest.firstName.toCharArray();
        for (int i = 0; i<stone.length; i++) {
            if (Character.isDigit(stone[i]) || Character.isSpaceChar(stone[i])) {
                correctName = false;
            }
        }
        Assert.assertTrue(correctName);
        System.out.println("Test First Name passed");
    }
    @Test
    public void testLastName() {
        boolean correctLastName = true;
        char[] stone = employeeTest.lastName.toCharArray();
        for (int i = 0; i<stone.length; i++) {
            if (Character.isDigit(stone[i]) || Character.isSpaceChar(stone[i])) {
                correctLastName = false;
            }
        }
        Assert.assertTrue(correctLastName);
        System.out.println("Test Last Name passed");
    }
    @Test
    public void testDateOfBirth() {
        boolean goodDate = true;
        String ourDate = employeeTest.dateWasBorn;
        char[] stone = ourDate.toCharArray();
        for (int i = 0; i<stone.length; i++) {
            if ((Character.isLetter(stone[i]) || Character.isSpaceChar(stone[i])) && stone.length == 10) {
                goodDate = false;
            }
        }
        Assert.assertTrue(goodDate);
        System.out.println("Test Date Of Birth passed");
    }
    @Test
    public void testDepartment() {
        boolean dept = false;
        if (employeeTest.theirDepartment.equals("Production") || employeeTest.theirDepartment.equals("Finance") ||
                employeeTest.theirDepartment.equals("Human resources") || employeeTest.theirDepartment.equals("Research and development")
                || employeeTest.theirDepartment.equals("Customer service")) {
            dept = true;
        } else {
            dept = false;
        }
        Assert.assertTrue(dept);
        System.out.println("Test dDepartment passed");
    }
    @Test
    public void testLocation() {
        boolean locationTrue = true;
        char[] stone = employeeTest.theirLocation.toCharArray();
        for (int i = 0; i<stone.length; i++) {
            if (Character.isDigit(stone[i]) || Character.isSpaceChar(stone[i])) {
                locationTrue = false;
            }
        }
        Assert.assertTrue(locationTrue);
        System.out.println("Test Location passed");
    }
    @Test
    public void testPosition() {
        boolean realPosition = true;
        if (employeeTest.positionOfThisGuy.equals(employeeTest.developer)
                || employeeTest.positionOfThisGuy.equals(employeeTest.owner)
                || employeeTest.positionOfThisGuy.equals(employeeTest.qaTester)
                || employeeTest.positionOfThisGuy.equals(employeeTest.ba)
                || employeeTest.positionOfThisGuy.equals(employeeTest.managerDevTeam)
                || employeeTest.positionOfThisGuy.equals(employeeTest.customerService)
                || employeeTest.positionOfThisGuy.equals(employeeTest.managerQATeam)
                || employeeTest.positionOfThisGuy.equals(employeeTest.techSupport)) {
            realPosition = true;
        } else {
            realPosition = false;
        }
        Assert.assertTrue(realPosition);
        System.out.println("Test Position passed");
    }
    @Test
    public void testSalary() {
        boolean realSalary;
        if(employeeTest.salary <= 0) {
            realSalary = false;
        } else {
            realSalary = true;
        }
        Assert.assertTrue(realSalary);
        System.out.println("Test Salary Passed");
    }
    @Test
    public void testEmail() {
        Pattern r = Pattern.compile(employeeTest.emailPattern);
        Matcher m = r.matcher(employeeTest.email);
        Assert.assertTrue(m.matches());
        System.out.println("Test Email Passed");
    }
    @Test
    public void testPhone() {
        boolean phoneYes = true;
        char[] phoneNow = employeeTest.phone.toCharArray();
        for (int i = 0; i<phoneNow.length;i++) {
            if (Character.isLetter(phoneNow[i])) {
                phoneYes = false;
            }
        }
        Assert.assertTrue(phoneYes);
        System.out.println("Test Phone passed");
    }
    @Test
    public void testBenefits() {
        double bonus;
        bonus = employeeTest.calculateEmployeeBonus(3,employeeTest.veryGoodPer);
        bonus = (employeeTest.salary*bonus) + employeeTest.salary;
        Assert.assertTrue(employeeTest.salary < bonus);
        System.out.println("Test Benefits passed");
    }


}



