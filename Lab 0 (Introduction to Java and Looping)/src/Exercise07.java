
public class Exercise07 {
	/*
	 * Complete a Java method printHollowSquare(int N) that prints a hollow
	square pattern with N rows and columns using a ‘while’ loop.
	 * 
	 */

	public static void printHollowSquare(int N) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == 1 || j == 1 || i == N || j == N) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {


		System.out.println("Exercise 7 printHollowSquare(5)");
		System.out.println("Your answer is ");
		printHollowSquare(5);

	}

}