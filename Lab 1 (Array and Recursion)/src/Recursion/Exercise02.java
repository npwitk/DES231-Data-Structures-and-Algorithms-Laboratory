package Recursion;

public class Exercise02 {
	static int sumDigit(int n) {
		int sum = 0;  
		if (n <= 0) {
			return 0;
		} else {
			return sum + (n%10)+sumDigit(n/10);
		}
	} 

	public static void main(String[] args) {

		// Uncomment these lines below to test your sumDigit code

		System.out.println("sumDigit(123456789)");
		System.out.println("Your answer is " + sumDigit(123456789));
		System.out.println("The correct answer is 45");

	}
}