package Recursion;

public class Exercise03 {
	public static int sumEven(int n) {

		if (n <= 0) {
			return 0;
		} else {
			if (n % 2 == 0) {
				return n + sumEven(n - 2);
			} else {
				return sumEven(n - 1);
			}
		}
	}

	public static void main(String[] args) {
		// Uncomment these lines below to test your sumEven code

		System.out.println("Calculating sumEven(10):");
		System.out.println("Your answer is " + sumEven(10));
		System.out.println("The correct answer is 30");

	}
}
