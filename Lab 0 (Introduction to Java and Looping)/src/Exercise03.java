
public class Exercise03 {

	/*
	 * Exercise 3 Complete the method makeUpwardRightTriangle(int w) that generates
	 * an upward right triangle made by * characters. An example of output when w =
	 * 4 is as follows.
	 *
	 **
	 ***
	 ****
	 * 
	 */
	public static void makeUpwardRightTriangle(int w) {
		for (int i = 1; i < w + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {

		/*
		 * Checking Ex3: Uncomment the below block comment to test your deductByK method
		 */
		System.out.println("Exercise 3 makeUpwardRightTriangle(6)");
		System.out.println("Your answer is ");
		makeUpwardRightTriangle(6);
		System.out.println("The Correct answer is ");
		System.out.println("*\n**\n***\n****\n*****\n******\n");

	}

}