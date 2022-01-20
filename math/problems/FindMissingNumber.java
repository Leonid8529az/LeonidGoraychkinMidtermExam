package math.problems;

public class FindMissingNumber {
    int expectedMissingNumber = 9;
    int actualNumber;
    int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};

    public static void main(String[] args) {
        FindMissingNumber findMissingNumber = new FindMissingNumber();
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */
        int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
         findMissingNumber.actualNumber = findMissingNumber.missingNumber(array);
        System.out.println(findMissingNumber.actualNumber);

    }


    public int missingNumber(int[] here) {
        int starDevourer = 0;
        boolean missingOrNo;
        for (int i = 0; i<here.length; i++) {
            starDevourer = i+1;
            missingOrNo = true;
            for (int j = 0; j<here.length; j++) {
                if (starDevourer == here[j]) {
                    missingOrNo = false;
                }
            }
            if (missingOrNo == true) {
                break;
            }

        } return starDevourer;
    }
}
