
public class Exercise06 {
	/*
	 * Write a Java method calculatePower(int base, int exponent) that
	calculates the power of a base raised to an exponent using a ‘for’ loop.
	 * 
	 */

	public static void calculatePower(int base, int exponent) {
		int answer = base;
		for(int i = 1; i < exponent; i ++) {
			answer *= base;
		
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {


		System.out.println("Exercise 6 calculatePower(2,3)");
		System.out.println("Your answer is ");
		calculatePower(2,3);
		System.out.println("The Correct answer is ");
		System.out.println("8");

	}

}