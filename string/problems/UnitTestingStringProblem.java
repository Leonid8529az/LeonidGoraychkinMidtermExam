package string.problems;

import org.junit.Assert;
import org.junit.Test;

public class UnitTestingStringProblem {
    Anagram anagram = new Anagram();
    DetermineLargestWord determineLargestWord = new DetermineLargestWord();
    DuplicateWord duplicateWord = new DuplicateWord();
    Palindrome palindrome = new Palindrome();
    Permutation permutation = new Permutation();


    //Apply Unit Test into all the methods in this package.

    @Test
    public void anagram() {
        Assert.assertTrue(anagram.isAnagram(anagram.cat,anagram.act ));
        System.out.println("Anagram test passed");
    }
    @Test
    public void largerWord() {
        determineLargestWord.expectedMap.put(10,"biological");
        Assert.assertEquals(determineLargestWord.expectedMap,determineLargestWord.largestWord(determineLargestWord.s));
        System.out.println("Determine largest word test passed");
    }
    @Test
    public void duplicateWord() {
        duplicateWord.expectedMap.put(duplicateWord.javaCount,duplicateWord.java);
        duplicateWord.expectedMap.put(duplicateWord.isCount,duplicateWord.is);
        duplicateWord.expectedMap.put(duplicateWord.languageCount,duplicateWord.language);
        Assert.assertEquals(duplicateWord.duplicateWord(duplicateWord.st),duplicateWord.expectedMap);
        System.out.println("Duplicate word test passed");
    }
    @Test
    public void palindrome() {
        Assert.assertTrue(palindrome.palindrome(palindrome.theOneToUse));
        System.out.println("Palindrome test passed");
    }
    @Test
    public void permutation() {
        permutation.permutation("ABC");
        Assert.assertEquals(permutation.expectedOutput,permutation.actualOutput);
        System.out.println("Permutation test passed");

    }



}