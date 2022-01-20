package string.problems;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class DuplicateWord {
    public String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
    String java = "java", is = "is", language = "language";
    int javaCount = 3, isCount = 3, languageCount = 2;
    LinkedHashMap<Integer, String > expectedMap = new LinkedHashMap<Integer, String>();

    int a = 0;

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */
        DuplicateWord duplicateWord = new DuplicateWord();
        duplicateWord.duplicateWord(duplicateWord.st);

    }
    public LinkedHashMap<Integer, String> duplicateWord(String insertHere) {
        LinkedHashMap<Integer, String > hahaha = new LinkedHashMap<Integer, String>();
        int count = 0;
        insertHere = insertHere.toLowerCase();
        insertHere = insertHere.replace('.', ' ');
        String[] duplicateCheck = insertHere.split(" ");

        for (int i = 0; i < duplicateCheck.length; i++) {
            count = 1;
            for (int j = i+1; j<duplicateCheck.length; j++) {
                if (duplicateCheck[i].trim().equals(duplicateCheck[j].trim())) {
                    count++;
                    duplicateCheck[j] = "0";
                }
            }
            if (count >= 2 && duplicateCheck[i].length()>1) {
                hahaha.put(count, duplicateCheck[i]);
            }

        }
        double averageLength = 0;
        double park = 0;

        for(int i = 0; i<duplicateCheck.length; i++) {
            park+=duplicateCheck[i].length();
        }
        averageLength = park/duplicateCheck.length;
        System.out.println("Average length of the words is " + averageLength);
        return hahaha;

    }

}
