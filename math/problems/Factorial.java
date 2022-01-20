package math.problems;

import java.sql.SQLOutput;

public class Factorial {
    int actual;
    public Factorial(int f) {
        this.actual = factorialMaker(f);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial(5);
        System.out.println(factorial.actual);
    }

    public static int factorialMaker(int a) {
        int factorial = 1;
        if (a == 0) {
            return factorial;
        } else {
            factorial = a;
            factorial = factorial*(factorialMaker(factorial-1));
        }
        return factorial;

    }

}
