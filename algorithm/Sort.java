package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {

    long executionTime = 0;
	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */


    public int[] selectionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;

        for(int j=0; j<array.length-1; j++){
            int min = j;
            for(int i=j+1; i<array.length; i++) {
                if (array[i] < array[min])
                    min = i;
            }

            int temp = array[min];
            array[min] = array[j];
            array[j] = temp;
        }

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] insertionSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        int temp, sortIndex;
        for (int i = 1; i<list.length; i++) {
            temp = list[i];
            sortIndex = i-1;
            while (sortIndex>=0 && list[sortIndex] > temp) {
                list[sortIndex+1] = list[sortIndex];
                sortIndex--;
            }
            list[sortIndex+1] = temp;
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public int[] bubbleSort(int [] array){

        final long startTime = System.currentTimeMillis();
        int [] list = array;
        int count = 0;
        int temp;
        do {
            count = 0;
            for (int i = 0; i < list.length - 1; i++) {
                    if (list[i] > list[i+1]) {
                        temp = list[i];
                        list[i] = list[i+1];
                        list[i+1] = temp;
                        count++;
                    }
            }
        } while (count > 0);

        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    

    public int [] mergeSort(int [] array,int l, int r) {
        final long startTime = System.currentTimeMillis();
        int[] list = array;
        if (l < r) {

            int m = l + (r - l) / 2;
            mergeSort(list, l, m);
            mergeSort(list, m + 1, r);
            merge(list, l, m, r);


        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    

    public void quickSort(int[] array, int first, int second){
        final long startTime = System.currentTimeMillis();
        int a = first, b = second;
        int [] list = array;
        if (a < b) {
            int pivot = pivot(list,a,b);
            quickSort(list, a, pivot-1);
            quickSort(list, pivot+1, b);
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;

    }
    static int pivot(int[] array, int start, int end) {
        int pivot = array[end];
        int count = start-1;
        for (int i = start; i<end; i++) {
            if (array[i] < pivot) {
                count++;
                swap(array,count,i);

            }
        }
        swap(array,count+1,end);
        return count+1;
    }
    
    public int [] heapSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        int n = list.length;
        for (int i = n / 2 - 1; i >= 0; i--)
                heapify(list, n, i);
            for (int i = n - 1; i >= 0; i--) {

                int temporary = list[0];
                list[0] = list[i];
                list[i] = temporary;


                heapify(list, i, 0);
            }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
            return list;
        }

        void heapify(int A[], int n, int i) {
            int largest = i; // Initialize largest as root
            int left_child = 2 * i + 1; // left = 2*i + 1
            int right_child = 2 * i + 2; // right = 2*i + 2

            if (left_child < n && A[left_child] > A[largest])
                largest = left_child;


            if (right_child < n && A[right_child] > A[largest])
                largest = right_child;


            if (largest != i) {
                int swap = A[i];
                A[i] = A[largest];
                A[largest] = swap;

                heapify(A, n, largest);
            }
        }




    public int [] bucketSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        int max = max(list);
        int min = min(list);
        int numberOfBuckets = max - min + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; ++i) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int value : list) {
            int hash = hash(value, min, numberOfBuckets);
            buckets.get(hash).add(value);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                list[index++] = value;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    private static int hash(int elem, int min, int numberOfBucket) {
        return (elem - min) / numberOfBucket;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    
    public int [] shellSort(int [] array){
        final long startTime = System.currentTimeMillis();
        int [] list = array;
        for (int gap = list.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i <list.length; i++) {
                int key = list[i];
                int j = i;
                while (j >= gap && list[j - gap] > key) {
                    list[j] = list[j - gap];
                    j -= gap;
                }
                list[j] = key;
            }
        }
        final long endTime = System.currentTimeMillis();
        final long executionTime = endTime - startTime;
        this.executionTime = executionTime;
        return list;
    }

    public static void printSortedArray(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}
