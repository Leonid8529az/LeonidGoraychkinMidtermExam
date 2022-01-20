package string.problems;

public class Palindrome {
    String theOneToUse = "MADAM";

    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.palindrome("MADAM"));
    }
    public boolean palindrome(String insert) {
        boolean correct = false;
        String reversed ="";
        char[] tester = insert.toCharArray();
        for (int i = tester.length-1; i>=0; i--) {
            reversed+=tester[i];

        }
        if (reversed.equals(insert)) {
            correct = true;
        }
        return correct;

    }
}
