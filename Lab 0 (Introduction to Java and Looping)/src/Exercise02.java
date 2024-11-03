
public class Exercise02 {

	/*
	 * Exercise 2 Complete the method deductK(int M, int k) that generates a
	 * sequence of positive number M M-k M-2k M-3k ... .
	 */

	public static void deductK(int M, int k) {
		for (int i = M; i > 0; i -= k) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) {

		/* Checking Ex2: Remove the below block comment to test your deductByK method */

		System.out.println("Exercise 2  deductK(105,8)");
		System.out.println("Your answer is ");
		deductK(105, 8);
		System.out.println();
		System.out.println("The Correct answer is ");
		System.out.println("105 97 89 81 73 65 57 49 41 33 25 17 9 1");
		System.out.println();

	}

}