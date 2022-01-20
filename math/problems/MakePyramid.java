package math.problems;

public class MakePyramid {
    String expectedPyramid = "     * \n" +
            "    * * \n" +
            "   * * * \n" +
            "  * * * * \n" +
            " * * * * * \n" +
            "* * * * * * \n";
    String actualPyramid = "";
    public static void main(String[] args) {
        MakePyramid makePyramid = new MakePyramid();
        makePyramid.actualPyramid = makePyramid.pyramid();
        System.out.println(makePyramid.actualPyramid);



        /*   Implement a large Pyramid of stars in the screen with java.

                              *
                             * *
                            * * *
                           * * * *
                          * * * * *
                         * * * * * *

        */


        }
        public String pyramid() {
        int hello = 6;
        for (int i = 0; i<hello; i++) {
            for (int j =hello-i; j>1; j--) {
                actualPyramid+=" ";
            }
            for (int j = 0; j<=i; j++) {
                actualPyramid+="* ";
            }
            actualPyramid+="\n";
        }
        return actualPyramid;
        }
  }
