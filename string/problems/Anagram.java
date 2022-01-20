package string.problems;

import java.util.Arrays;

public class Anagram {
    String cat = "CAT";
    String act = "ACT";

    public static void main(String[] args) {
        String cat = "CAT";
        String act = "ACT";
        Anagram anagram = new Anagram();
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".
        System.out.println(anagram.isAnagram(cat,act));

    }
    public boolean isAnagram(String first, String second){
        boolean cool = false;
        char[] firstString = first.toCharArray();
        char[] secondString = second.toCharArray();
        Arrays.sort(firstString);
        Arrays.sort(secondString);
        if(Arrays.equals(firstString,secondString)) {
            cool = true;
        }
        return cool;
    }

}
