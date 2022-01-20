package string.problems;

public class Permutation {
    String[] expectedOutput = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};
    String[] actualOutput = new String[expectedOutput.length];

    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */
        Permutation permutation = new Permutation();
        permutation.permutation("ABC");


    }
    public void permutation(String reputation) {
        String accurate = "";
        int create = 0;
        char[] hello = reputation.toCharArray();
        for (int i = 0; i<hello.length; i++) {
            for (int j = 0; j<hello.length; j++) {
                for (int n = 0; n<hello.length; n++) {
                    if(i!=j && i!=n && j!=n) {
                        accurate+=hello[i];
                        accurate+=hello[j];
                        accurate+=hello[n];
                        actualOutput[create] = accurate;
                        create++;
                        accurate = "";
                    }
                }
            }
        }


    }
}

