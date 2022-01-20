package math.problems;

public class Fibonacci {
    boolean trueFibonacci = true;
    int[] fibonacciArray ={0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987,
            1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
            1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986};
    int[] actualArray = new int[40];

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacciMaker();
        for (int i = 0; i < fibonacci.actualArray.length; i++) {
            System.out.print(fibonacci.actualArray[i]+ " ");
            if (i%8 ==0) {
                System.out.println();
            }
        }

    }
    public void fibonacciMaker() {
        int first = 0, second =1, third;
        actualArray[0] = first;
        actualArray[1] = second;
        for (int i = 2; i < actualArray.length; i++) {
            third = first+second;
            actualArray[i] = third;
            first = second;
            second = third;
        }
    }
}
