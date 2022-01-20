package math.problems;

import org.junit.Assert;
import org.junit.Test;

public class UnitTestingMath {
    Factorial factorial = new Factorial(5);
    Fibonacci fibonacci = new Fibonacci();
    FindLowestDifference findLowestDifference = new FindLowestDifference();
    FindMissingNumber findMissingNumber = new FindMissingNumber();
    MakePyramid makePyramid = new MakePyramid();
    Pattern pattern = new Pattern();
    LowestNumber lowestNumber = new LowestNumber();




    @Test
    public void factorialTest() {
        int expectedFactorial = 120;
        Assert.assertEquals(expectedFactorial, factorial.actual);
        System.out.println("Factorial test passed");
    }
    @Test
    public void fibonacciTest() {
        fibonacci.fibonacciMaker();
        for(int i = 0; i<fibonacci.actualArray.length; i++) {
            if(fibonacci.fibonacciArray[i] != fibonacci.actualArray[i]) {
                fibonacci.trueFibonacci = false;
            }
        }
        Assert.assertTrue(fibonacci.trueFibonacci);
        System.out.println("Fibonacci test passed");
    }
    @Test
    public void findLowestDifferenceTest() {
        findLowestDifference.actualLowest = findLowestDifference.lowestDifference(findLowestDifference.array1,
                findLowestDifference.array2);
        Assert.assertEquals(findLowestDifference.expectedLowest, findLowestDifference.actualLowest, 1.0);
        System.out.println("Find lowest difference test passed");
    }
    @Test
    public void findMissingNumber() {
        findMissingNumber.actualNumber = findMissingNumber.missingNumber(findMissingNumber.array);
        Assert.assertEquals(findMissingNumber.expectedMissingNumber, findMissingNumber.actualNumber);
        System.out.println("Find missing number test passed");
    }
    @Test
    public void makePyramid() {
        makePyramid.actualPyramid = makePyramid.pyramid();
        Assert.assertTrue(makePyramid.actualPyramid.equals(makePyramid.actualPyramid));
        System.out.println("Make pyramid test passed");
    }
    @Test
    public void pattern() {
        boolean equal = true;
        pattern.getPattern();
        for(int i = 0; i<pattern.actualPattern.length; i++) {
            if(pattern.actualPattern[i] != pattern.expectedPattern[i]) {
                equal = false;
            }
        }
        Assert.assertTrue(equal);
        System.out.println("Pattern test passed");
    }
    @Test
    public void lowestNumber() {
        int actualLowest = lowestNumber.lowestYes(lowestNumber.array);
        Assert.assertEquals(lowestNumber.expectedLowest, actualLowest);
        System.out.println("Lowest number test passed");
    }


    }

