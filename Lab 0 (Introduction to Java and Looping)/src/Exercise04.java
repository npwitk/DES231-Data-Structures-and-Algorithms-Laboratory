
public class Exercise04 {
	/*
	 * Exercise 4 Complete the method makeDownwardRightTriangle(int w) that
	 * generates a downward right triangle made by * characters. An example of
	 * output when w = 4 is as follows.
	 ****
	 ***
	 **
	 *
	 * 
	 */

	public static void makeDownwardRightTriangle(int w) {

		for(int i = w; i > 0; i--) {
			for(int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
	}



	public static void main(String[] args) {

		/* Checking Ex4: Remove the below block comment to test your deductByK method */

		System.out.println("Exercise 4 makeDownwardRightTriangle(5)");
		System.out.println("Your answer is ");
		makeDownwardRightTriangle(5);
		System.out.println("The Correct answer is ");
		System.out.println("*****\n****\n***\n**\n*\n");

	}

}