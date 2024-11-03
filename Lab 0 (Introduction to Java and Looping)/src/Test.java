
public class Test {

	public static int findResult(int n) {
		int sum = 0;
		int number = 0;
		while (number <= n) {
			if (number % 2 == 1) {
				sum += number;
			}
			number++;
		}
		return sum;
		} 
	
	
	public static void makeUpwardRightTriangle(int w) {
		for (int i = 1; i < w + 1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");	
			}
			System.out.println("");
				}
				
		}
	public static void main(String[] args) {

		makeUpwardRightTriangle(5);
		System.out.println(findResult(12));

	}

}