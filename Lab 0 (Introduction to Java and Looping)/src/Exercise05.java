
public class Exercise05 {
	/*
	 * Exercise 5 Complete the method makeUpwardIsosceles(int w) that generates an
	 * upward isosceles made by * characters. The shape of the output when w = 4 is
	 * as follows.
	 *
	 ***
	 *****
	 *******
	 *********
	 * 
	 */

	public static void makeUpwardIsosceles(int w) {
		int height = w + 1;
		for (int i = 1; i <= height; i++) {
			
			for(int s = 1; s <= height - i; s++) {
				System.out.print(" ");
			}
			
			for(int j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			
			
			
			System.out.println("");
		}

	}

	public static void main(String[] args) {

		/* Checking Ex5: Remove the below block comment to test your deductByK method */

		System.out.println("Exercise 5 makeUpwardIsosceles(4)");
		System.out.println("Your answer is ");
		makeUpwardIsosceles(4);
		System.out.println("The Correct answer is ");
		System.out.println("    *\n   ***\n  *****\n *******\n*********\n");

	}

}