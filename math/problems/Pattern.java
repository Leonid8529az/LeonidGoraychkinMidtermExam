package math.problems;

public class Pattern {
	int[] expectedPattern = {100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 88, 86, 84, 82, 80, 78, 76, 74, 72, 70,
			67, 64, 61, 58, 55, 52, 49, 46, 43, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};
	int[] actualPattern = new int[expectedPattern.length];
	public static void main(String[] args) {

		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */

	}

	public void getPattern() {

		int z = 100, count = 0;
		actualPattern[count] = z;
		System.out.print(z + " ");
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 10; j++) {
				count++;
				z -= i;
				actualPattern[count] = z;

			}

		}

	}
}
