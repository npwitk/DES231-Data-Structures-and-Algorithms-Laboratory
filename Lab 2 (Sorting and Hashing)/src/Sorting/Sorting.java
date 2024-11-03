package Sorting;

public class Sorting {
	/**
	 * Swaps two elements in an integer array.
	 *
	 * This method swaps the elements at the specified positions (i and j) within
	 * the given integer array (A). It exchanges the values at A[i] and A[j] by
	 * temporarily storing the value of A[i] in a temporary variable, then assigning
	 * the value of A[j] to A[i], and finally assigning the temporary value to A[j].
	 *
	 * @param A The integer array in which elements are to be swapped.
	 * @param i The index of the first element to be swapped.
	 * @param j The index of the second element to be swapped.
	 */
	static void swap(int[] A, int a, int b) { // Pass in (Array, index1, index2)
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
		//Fully understood!
	}

	/**
	 * Prints the elements of an integer array.
	 *
	 * This method prints the elements of the given integer array (A) to the
	 * standard output stream, separated by spaces, followed by a newline character
	 * to create a visually formatted list of the array's contents.
	 *
	 * @param A The integer array to be printed.
	 */
	static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) { //.length คือจำนวนใน Array ทั้งหมด เริ่มนับตั้งแต่ 1 ดังนั้นมันจะไปถึงตัวสุดท้าย ก็คือ index - 1
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Finds the index of the smallest element within a specified range of an
	 * integer array.
	 *
	 * This method searches for the index of the smallest element within the
	 * subarray defined by the given start and end indices in the provided integer
	 * array (A). It iterates through the elements within the specified range and
	 * maintains the index of the smallest element encountered. The index of the
	 * smallest element is returned as the result.
	 *
	 * @param A     The integer array in which the smallest element is to be found.
	 * @param start The starting index of the subarray to search.
	 * @param end   The ending index of the subarray to search.
	 * @return The index of the smallest element within the specified subarray
	 *         range.
	 */
	static int findIndexSmallest(int[] A, int start, int end) { //(Array ไร, start index, stop index) 
		int minIndex = start; // Initialise ให้ตัวเริ่มมันน้อยสุดก่อน
		for (int j = start; j <= end; j++) {
			if (A[minIndex] > A[j]) //มันก็ไล่ดูไปเรื่อย ๆ ถ้า A[minIndex] มันมากกว่าตัวใหม่ที่รันไปเรื่อย ๆ
				//ก็แปลว่า ตัวใหม่มันน้อยกว่า ก็แทนด้วยตัวนั้นเลย   
				minIndex = j; // Remember index of new minimum
		}
		return minIndex; //สิ่งที่ได้ก็คือ minIndex ตามตัว Index ของ Element ที่ค่าน้อยสุด ใน provided range
		//เวลาเช็คก็อย่าลืมให้ end เป็น Array.length - 1 [เพราะมันใช้ <=]
	}

	/**
	 * Sorts an integer array using the Selection Sort algorithm.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Selection Sort algorithm. It iteratively selects the smallest element from
	 * the unsorted part of the array and swaps it with the element at the beginning
	 * of the unsorted part, effectively partitioning the array into sorted and
	 * unsorted sections.
	 *
	 * @param A The integer array to be sorted.
	 */
	
	// เริ่มทำเองตั้งแต่ตรงนี้เป็นต้นไป
	
	static void SelectionSort(int[] inputArray) {
		for(int i = 0; i < inputArray.length - 1; i++) { //Loop ทุกตัวใน Array ยกเว้นตัวสุดท้าย เพราะจะถือว่า sorted แล้ว
			//อันนี้เป็น A.length - 1 ก็เพราะว่า ตัวสุดท้ายไม่ต้องไปยุ่ง ถือว่า Automatically sorted
			int minIndex = i; // Index of smallest remaining value. -- จริง ๆ บรรทัดนี้ไม่จำเป็นเลย
			minIndex = findIndexSmallest(inputArray, i, inputArray.length - 1);
			swap(inputArray, minIndex, i); //(Array, position1, position2)
		}
	}

	/**
	 * Sorts an integer array using the Insertion Sort algorithm.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Insertion Sort algorithm. It iteratively builds a sorted subarray by shifting
	 * elements one at a time and inserting them into their correct positions within
	 * the sorted part of the array.
	 *
	 * @param A The integer array to be sorted.
	 */
	
	static void InsertionSort(int[] inputArray) { // Ex 1b Complete the method InsertionSort
		for (int i = 1; i < inputArray.length; i++) { //อย่าลืมว่าเริ่มจาก index 1 เพราะเรา Assume ว่าตัวแรกน้อยสุดอยู่ละ ไม่ต้องไปสนใจ
			int tempValue = inputArray[i]; //เอาค่าออกมา temporary เพ่ือมา Compare นู้นนี่
			for (int j = i-1; j >= 0 && inputArray[j] > tempValue; j--) { //for loop นี้เอาไว้เช็คข้างหน้าที่เรียงแล้วให้สลับ 
				//condition คือ reach beginning & เจอตัวเลขน้อยกว่า ; ทำไปเรื่อย j--
				swap(inputArray, j+1, j); //ขยับ j+1 ไป j
				printArray(inputArray);	//Print เพื่อดูทุกขั้นตอน
			}
		}
	}

	/**
	 * Sorts an integer array using the Merge Sort algorithm recursively.
	 *
	 * This method sorts the given integer array (A) in ascending order using the
	 * Merge Sort algorithm. It recursively divides the array into smaller
	 * subarrays, sorts them individually, and then merges them back together.
	 *
	 * @param A The integer array to be sorted.
	 */
	private static void RecursiveMergeSort(int[] inputArray) {
		int inputLength = inputArray.length; //8
		
		if (inputLength < 2) { //ตรงนี้เปรียบเสมือน Base case ใน recursive - ถ้าเป็น one element array แล้ว
			// หรือไม่ก็เป็น empty array ก็ให้หยุด -> return
			return;
		}

		int midIndex = inputLength / 2; //4 -- ถึงถ้าเป็น decimal value มันก็จะปัดลงหมดเพราะเราเรียก int
		int[] leftHalf = new int[midIndex]; //Initialise Array with length of 4 - Half the length of original array
		int[] rightHalf = new int[inputLength - midIndex]; // Initialise Array with length of 8-4 = 4
		// จริง ๆ rightHalf จะใช้เป็น midIndex เหมือนกันก็ได้ แต่ว่ามันจะไม่ work ถ้า original array เป็นเลขคี่

		// leftHalf array
		for (int i = 0; i < midIndex; i++) { // Loop from 0 to length of leftHalf (index 0-3) ก็ได้ 4 elements
			//Put first half member to array to be leftHalf
			leftHalf[i] = inputArray[i]; //leftHalf array will contain all the elements of the left half of original array
		}
		
		// rightHalf array
		for (int i = midIndex; i < inputLength; i++) { //The other way round (index 4-7) ได้ 4 elements
			rightHalf[i - midIndex] = inputArray[i]; //เริ่มจาก Index 4-4=0 ของ rightHalf เพื่อเก็บได้อย่างถูกต้อง
		}
		
		RecursiveMergeSort(leftHalf); //Run all the way to base case X | X | X | X  -- X | X | X | X
		RecursiveMergeSort(rightHalf);
		
		//ตอนนี้คือได้เป็น one element array กันหมดแล้ว
		
		merge(inputArray, leftHalf, rightHalf);

	}

	/**
	 * Merges two sorted integer arrays into one sorted array.
	 *
	 * This method merges two sorted integer arrays, `leftHalf` and `rightHalf`,
	 * into a single sorted array `A`. It iterates through both input arrays,
	 * comparing elements and placing them in ascending order in the resulting
	 * merged array.
	 *
	 * @param A         The target integer array where the sorted elements will be
	 *                  stored.
	 * @param leftHalf  The first sorted integer array to be merged.
	 * @param rightHalf The second sorted integer array to be merged.
	 */
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		int i = 0; //Walk from left half array
		int j = 0; //Walk from right half array
		int k = 0; //Walk through merged array

		while (i < leftSize && j < rightSize) { //ทำไปจนกว่าจะ run out of element in left or right array
			if (leftHalf[i] < rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
				k++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
				k++;
			}
		}
		// Copy any remaining elements from the leftHalf array, if any.
		while (i < leftSize) { //ถ้าแบบยังเหลือ 1 ตัว แต่ถ้าไม่เหลือแล้วก็ skip part นี้ไปเลย
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		// Copy any remaining elements from the leftHalf array, if any.
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
	}

	/**
	 * Sorts an integer subarray using the Quick Sort algorithm recursively.
	 *
	 * This method sorts a subarray of the given integer array (A) in ascending
	 * order using the Quick Sort algorithm. It recursively partitions the array
	 * into smaller subarrays, and then sorts them individually.
	 *
	 * @param A     The integer array containing the subarray to be sorted.
	 * @param start The starting index of the subarray to be sorted.
	 * @param end   The ending index of the subarray to be sorted.
	 */
	static void RecursiveQuickSort(int[] inputArray, int lowIndex, int highIndex) { //index 0 to last element of an array
		if (lowIndex >= highIndex) {
			return;
		}
			int pivot = inputArray[highIndex]; //เลือก Pivot อยู่ท้ายสุดของ Array
			
			//Partitioning จะต้องมี Left Pointer, Right Pointer 
			//โดย Left Pointer จะ walk ไปเรื่อย ๆ จนกว่าจะเจอเลขที่ bigger than the pivot แล้วหยุด
			//โดย Right Pointer จะได้จากขวามาซ้ายไปเรื่อย ๆ จนกว่าจะเจอเลขที่ smaller than the pivot แล้วหยุด
			//แล้วก็ Swap เลขที่ตำแหน่ง lp, rp อยู่ แล้วก็ repeat ไปเรื่อย ๆ
			//จนกว่า lp, rp จะไปอยู่ที่ตำแหน่งเดียวกัน แล้วก็สลับ position ของ rp,lp กับ pivot แค่นี้ก็ partition เสร็จแล้ว
			
			int leftPointer = lowIndex;
			int rightPointer = highIndex;
			
			while(leftPointer < rightPointer) {
				
				while(inputArray[leftPointer] <= pivot && leftPointer < rightPointer) {
					leftPointer++;
				}
				
				while(inputArray[rightPointer] >= pivot && leftPointer < rightPointer) {
					rightPointer--;
				}
				
				swap(inputArray, leftPointer, rightPointer);
			}
			
			swap(inputArray, leftPointer, highIndex); //Swap with pivot
			
			RecursiveQuickSort(inputArray, lowIndex, leftPointer - 1);
			RecursiveQuickSort(inputArray, leftPointer + 1, highIndex);
			
			/*int[] L = new int[A.length];
			int[] R = new int[A.length];
			int l_count = 0;
			int r_count = 0;
			for (int i = start; i < end; i++) {
				if (A[i] < pivot) {
					L[l_count] = A[i];
					l_count++;
				} else {
					R[r_count] = A[i];
					r_count++;
				}
			}

			for (int i = 0; i < l_count; i++) {
				A[start + i] = L[i];
			}
			A[l_count + start] = pivot;
			for (int i = 0; i < r_count; i++) {
				A[l_count + start + i + 1] = R[i];
			}
			// Ex4. Complete this method.
			// Call itself for sorting the leftHalf and the rightHalf*/
		

	}

	public static void main(String[] args) {

//		/**
//		 * The correct answer for a Selection Sort is
//		 * 
//		 * 9 12 89 36 64 22 75 51 45	
//		 * 9 12 22 36 64 89 75 51 45	
//		 * 9 12 22 36 45 89 75 51 64	
//		 * 9 12 22 36 45 51 75 89 64	
//		 * 9 12 22 36 45 51 64 89 75	
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("Selection Sort");
		int[] A = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(A);
		System.out.println("Your Solution is ");
		SelectionSort(A);
		printArray(A);

//		/**
//		 * The correct answer for an Insertion Sort is
//		 * 
//		 * 12 45 89 36 64 22 75 51 9	
//		 * 12 45 36 89 64 22 75 51 9 	
//		 * 12 36 45 89 64 22 75 51 9 	
//		 * 12 36 45 64 89 22 75 51 9 	
//		 * 12 36 45 64 22 89 75 51 9 	
//		 * 12 36 45 22 64 89 75 51 9 	
//		 * 12 36 22 45 64 89 75 51 9 	
//		 * 12 22 36 45 64 89 75 51 9 	
//		 * 12 22 36 45 64 75 89 51 9 	
//		 * 12 22 36 45 64 75 51 89 9 	
//		 * 12 22 36 45 64 51 75 89 9 	
//		 * 12 22 36 45 51 64 75 89 9 	
//		 * 12 22 36 45 51 64 75 9 89 	
//		 * 12 22 36 45 51 64 9 75 89 	
//		 * 12 22 36 45 51 9 64 75 89 	
//		 * 12 22 36 45 9 51 64 75 89 	
//		 * 12 22 36 9 45 51 64 75 89 	
//		 * 12 22 9 36 45 51 64 75 89 	
//		 * 12 9 22 36 45 51 64 75 89 	
//		 * 9 12 22 36 45 51 64 75 89 	
//		 */
		System.out.println("\nInsertion Sort");
		int[] B = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(B);
		System.out.println("Your Solution is ");
		InsertionSort(B);
		printArray(B);

//		/**
//		 * The correct answer for a Merge Sort is
//		 * 
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("\nMerge Sort");
		int[] C = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(C);
		System.out.println("Your Solution is ");
		RecursiveMergeSort(C);
		printArray(C);

//		/**
//		 * The correct answer for a Quick Sort is
//		 * 
//		 * 9 12 22 36 45 51 64 75 89	
//		 */
		System.out.println("\nQuick Sort");
		int[] D = { 45, 12, 89, 36, 64, 22, 75, 51, 9 };
		printArray(D);
		System.out.println("Your Solution is ");
		RecursiveQuickSort(D, 0, D.length - 1);
		printArray(D);
		
	}

}

