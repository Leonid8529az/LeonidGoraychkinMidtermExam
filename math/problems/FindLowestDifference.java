package math.problems;

import java.util.Map;

public class FindLowestDifference {
    double expectedLowest = 1.0;
    double actualLowest;
        /*
         Implement in java.
         Read this below two array. Find the lowest difference between the two array cell.
         The lowest difference between cells is 1
        */
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};

    public static void main(String[] args) {
        FindLowestDifference findLowestDifference = new FindLowestDifference();
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};
        System.out.println(findLowestDifference.lowestDifference(array1,array2));

    }

        public double lowestDifference (int[] first, int[] second) {
        double pirateShip = Math.sqrt(Math.pow(first[0]-second[0],2));
        double mountainKing;
            for (int i = 0; i<first.length; i++) {
                for (int j = 0; j<second.length; j++) {
                    mountainKing = Math.sqrt(Math.pow(first[i] - second[j],2));
                    if (mountainKing < pirateShip) {
                        pirateShip = Math.sqrt(Math.pow(first[i]-second[j],2));
                    }
                }
        }
            return pirateShip;
    }

}
