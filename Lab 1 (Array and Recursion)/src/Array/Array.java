package Array;

public class Array {
	final int size; // The maximum capacity of A
	int[] A;
	int load = 0; // number of elements in A -- นับเฉพาะจำนวนตัวที่มีใน Array

	Array(int n)
    { size = n;
      A = new int[size];  
    }

	// Ex4 a
	void addFirst(int e) {
		if (load < size) {
			for (int i = load; i > 0; i--) {
				A[i] = A[i - 1];
			}
		}
		A[0] = e;
		load++;

	}

	// Ex4 b
	void addLast(int e) {
		if (load < size) {
			A[load] = e; 
			load++;
		}
	}

	// Ex4 c
	void addAtIndex(int e, int index) {
		if (load < size) {
			for (int i = load; i > index; i--) {
				A[i] = A[i - 1];
			}
			A[index] = e;
			load++;
		}

	}

	// Ex4 d
	int removeFirst() {
		if(load == 0)
			return -1; //Array is empty.
		for(int i = 0; i < load-1; i++) {
			A[i] = A[i+1];
		}
		A[load - 1] = 0; //Clear last element
		load--;
		return 0; //Success
	}

	// Ex4 e
	int removeLast() {
		if(load == 0) {
			return -1; //Array is empty.
		}
		A[load] = 0;
		load--;
		return 0; //Success
	}

	// Ex4 f
	int removeAtIndex(int index) {
		if(load == 0) {
			return -1; //Array is empty.
		}
		for(int i = index; i < load - 1; i++) {
			A[i] = A[i + 1];
		}
		A[load - 1] = 0; //Clear last element
		load--;
		return 0; //
	}

	// Ex4 g
	int getElementAtIndex(int index) {
		if(load == 0 || index >= load) {
			return -1; //Array is empty.
		}
		return A[index]; //Output.
	}

	// Ex4 h
	void setElementAtIndex(int val, int index) {
		A[index] = val;
	}

	void printArray() {
		for (int i = 0; i < load; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println("\nArray load is " + load);
		System.out.println();
	}
	
	boolean findPairWithSum(int sum) {
		if (load < 2) return false;
        
        // Using two pointers approach
        int left = 0;
        int right = load - 1;
    
        while (left < right) {
            int currentSum = A[left] + A[right];
            if (currentSum == sum) {
               return true; // Pair found
            } else if (currentSum < sum) {
               left++; // Move left pointer to the right
            } else {
               right--; // Move right pointer to the left
            }
        }
        return false; // No pair found
    }
	
	
	public static void main(String[] args) {
		Array A = new Array(10);
	    //A.printArray();
        //Uncomment this section to test Ex4 a 
        
        A.addFirst(9);
        A.addFirst(1);
        A.addFirst(4);
        System.out.println("After addFirst 9, 1, and 4 to A");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 9 \nArray load is 3");
       

        //Uncomment this section to test Ex4 b 

        System.out.println("----------------------------------");  
        A.addLast(2);
        A.addLast(5);
        A.addLast(8);
        System.out.println("After addLast 2, 5, and 8 to A");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 9 2 5 8 \nArray load is 6");
        

	//Uncomment this section to test Ex4 c 
        
        System.out.println("----------------------------------"); 
        A.addAtIndex(6, 2);
        A.addAtIndex(3, 4);
        System.out.println("After add 6 at index 2, and add 3 at index 4 to A ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n4 1 6 9 3 2 5 8 \nArray load is 8");
        

         //Uncomment this section to test Ex4 d
        
        System.out.println("----------------------------------"); 
        A.removeFirst();
        A.removeFirst();
        System.out.println("After removeFirst twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 9 3 2 5 8 \nArray load is 6");
         

         //Uncomment this section to test Ex4 e
        
        System.out.println("----------------------------------"); 
        A.removeLast();
        A.removeLast();
        System.out.println("After removeLast twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 9 3 2 \nArray load is 4");
         

         //Uncomment this section to test Ex4 f
        
        System.out.println("----------------------------------"); 
        A.removeAtIndex(1);
        A.removeAtIndex(1);
        System.out.println("After removeAtIndex 1 twice ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 2 \nArray load is 2");
         

        //Uncomment this section to test Ex4 g
        
        System.out.println("----------------------------------");
        A.setElementAtIndex(7, 1);
        System.out.println("After set value at index 1 to 7 ");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 7 \nArray load is 2");
         

	 //Uncomment this section to test Ex4 h
        
        System.out.println("----------------------------------");
        System.out.println("Your Answer is");
        System.out.println("Value at A[1]= " + A.getElementAtIndex(1));
        System.out.println("Correct Answer is\nValue at A[1]= 7");
	
	
//optional
	// Uncomment this section to test Ex 5
        System.out.println("----------------------------"
        		+ "------");
        A.addLast(7);
        A.addLast(9);
        A.addLast(9);
        A.addLast(11);
        A.addLast(11);
        A.addLast(11);
        System.out.println("After adding 7, 9, 9, 11, 11, 11 to A");
        System.out.println("Your Answer is");
        A.printArray();
        System.out.println("Correct Answer is\n6 7 7 9 9 11 11 11 \nArray load is 8");
	
	System.out.println("----------------------------------");
        int sum = 20;
        System.out.println("Your Answer for findPairWithSum(" + sum + "): " + A.findPairWithSum(sum));
        //System.out.println("Correct Answer for findPairWithSum(" + sum + "): true");
      
    }
}