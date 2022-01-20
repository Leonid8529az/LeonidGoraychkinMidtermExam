package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class UnitTestSorting {
    Sort sort = new Sort();
    int [] sortedArray =   {0,1,2,4,5,6,9};
    boolean sortedArr = true;

    @Test
    public void selectionSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.selectionSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Selection sorting test passed");
    }
    @Test
    public void insertionSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.insertionSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Insertion sorting test passed");
    }
    @Test
    public void bubbleSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.bubbleSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Bubble sorting test passed");
    }
    @Test
    public void mergeSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.mergeSort(unSortedArray,0,unSortedArray.length-1);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Merge sorting test passed");
    }
    @Test
    public void quickSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.quickSort(unSortedArray,0,unSortedArray.length-1);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Quick sorting test passed");
    }
    @Test
    public void heapSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.heapSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Heap sorting test passed");
    }
    @Test
    public void bucketSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.bucketSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Bucket sorting test passed");
    }
    @Test
    public void shellSort() {
        int [] unSortedArray = {6,9,2,5,1,0,4};
        sort.shellSort(unSortedArray);
        sortedArr = true;
        for(int i = 0; i<sortedArray.length; i++) {
            if(sortedArray[i] != unSortedArray[i]) {
                sortedArr = false;
            }
        }
        Assert.assertTrue(sortedArr);
        System.out.println("Shell sorting test passed");
    }
}
