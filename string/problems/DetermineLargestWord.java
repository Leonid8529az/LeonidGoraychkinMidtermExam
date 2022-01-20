package string.problems;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DetermineLargestWord {
    Map<Integer,String> expectedMap = new LinkedHashMap<Integer, String>();

    String s="Human brain is a biological learning machine";
    Scanner scanner = new Scanner(s);
    String test =scanner.next();

    public static void main(String[] args) {
        DetermineLargestWord determineLargestWord = new DetermineLargestWord();
        System.out.println(determineLargestWord.largestWord(determineLargestWord.s));

        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
    }
    public LinkedHashMap<Integer, String> largestWord(String thisOne) {
        scanner = new Scanner(thisOne);
        while (scanner.hasNext()) {
            String another = scanner.next();
            if (another.length() > test.length()) {
                test = another;
            }
        }

        LinkedHashMap<Integer, String> wordNLength = findTheLargestWord(test);

        //implement
        return wordNLength;

    }

    public static LinkedHashMap<Integer, String> findTheLargestWord(String wordGiven){
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(wordGiven.length(),wordGiven);
        //implement

        return map;
    }
}
