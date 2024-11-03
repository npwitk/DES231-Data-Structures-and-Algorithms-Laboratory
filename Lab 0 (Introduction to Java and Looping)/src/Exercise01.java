
public class Exercise01 {

	/*
	 * 
	 * Exercise 1: Complete the method makeMultTable(int M) that generates a
	 * multiplication table from an input number M, it shows values of 1M until 12M
	 * in this form. Use tab(\t) to make a tab in java. X M 1 M 2 2M ... 12 12M
	 * 
	 */

	public static void makeMultTable(int M) {
		int i;
		System.out.println("X \t " + M + " (M)");
		for (i = 1; i < 13; i++) {
			System.out.println(i + "\t" + M * i);
		}
	}

	public static void main(String[] args) {

		/*
		 * Checking Ex1: Remove the below block comment to test your makeMultTable
		 * method
		 */

		System.out.println("Exercise 1\n");
		System.out.println("makeMultTable(63)");
		System.out.println("Your answer is ");
		makeMultTable(63);
		System.out.println("The Correct answer is ");
		System.out.println(
				"X\t63\n1\t63\n2\t126\n3\t189\n4\t252\n5\t315\n6\t378\n7\t441\n8\t504\n9\t567\n10\t630\n11\t693\n12\t756");
		System.out.println();

	}

}