package Recursion;

public class Exercise01 {
	static int subsum(int n) {
		int sum = 0;
		
		if (n == 1) {
			return 1;
		} else if (n%2 == 0) {
			return -n + subsum(n-1);
		} else {
			return n + subsum(n-1);
		}
	}
		/* for (int i = n; i >= 1; i--) {
			sum = n * (int) Math.pow(-1, n+1);
			sum += subsum(n-1);
		} 
		return sum;
	} */

	public static void main(String[] args) {

		// Test Uncomment these lines below to test your subsum code
		
		 System.out.println("Calculating subsum(10):");
		 System.out.println("Your answer is "+subsum(10));
		 System.out.println("The correct answer is -5");
		 System.out.println("-----------------------");
		 
	}
}