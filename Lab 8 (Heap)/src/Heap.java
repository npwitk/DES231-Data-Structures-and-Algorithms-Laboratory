/**
 * The `Heap` class represents a simple heap data structure.
 * A heap is a specialized tree-based data structure that satisfies the heap property.
 * In this implementation, the heap is represented as an array.
 * The class provides methods for insertion, deletion, and heap sort.
 *
 */
public class Heap {
	
	/** The current number of elements in the heap. */
	int load = 0;
	
	/** The array representing the heap. */
	int[] hArray = new int[100];

	/**
     * Constructs an empty heap.
     */
	Heap() {
	}

	/**
     * Performs the reheapUp operation to maintain the heap property after insertion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapUp(int currentIndex) {
		 // Exercise 1
		//  add your code here 
		if (currentIndex > 0) { //if index isn't a leaf node
			int parentIndex = (currentIndex - 1)/2;
			if (hArray[currentIndex] > hArray[parentIndex]) { 
				swap(hArray, currentIndex, parentIndex);
			}
			reheapUp(parentIndex); //recursive ซ้ำไปเรื่อย ๆ
		}
	}

	/**
     * Inserts a new element into the heap and performs the necessary reheapUp operation.
     *
     * @param data The data to be inserted into the heap.
     */
	void insert(int data) {

		hArray[load] = data; //add new data to the next current data
		load++;
		reheapUp(load - 1);
	}

	 /**
     * Performs the reheapDown operation to maintain the heap property after deletion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapDown(int currentIndex) {

		int lastIndex = load - 1;
		
		if (2 * currentIndex + 1 <= lastIndex) { // 2 times current idex + 1
			
			int largestChildIndex;
			
			int leftNodeIndex = 2 * currentIndex + 1; //leftChild อยู่ที่ 1
			int rightNodeIndex = 2 * currentIndex + 1 + 1; //rightChild อยู่ที่ 2

			if (rightNodeIndex > lastIndex) {
				largestChildIndex = leftNodeIndex;
			} else if (hArray[rightNodeIndex] > hArray[leftNodeIndex]) {
				largestChildIndex = rightNodeIndex;
			} else {
				largestChildIndex = leftNodeIndex;
			}

			if (hArray[currentIndex] < hArray[largestChildIndex]) {
				swap(hArray, currentIndex, largestChildIndex);
				reheapDown(largestChildIndex);
			}
		}
	}

	/**
     * Deletes the root element of the heap and performs the necessary reheapDown operation.
     *
     * @return The value of the root element that was deleted.
     */
	int deleteRoot() {
		// Exercise 4a
		// add your code here 
		int temp = hArray[0]; // ให้ temp เป็น root ไว้ก่อน
		if (load - 1 >= 0) {  //if last index > 0 -> if level > 0 -> root has children
			hArray[0] = hArray[load-1]; // แทนค่า root ด้วยตัวสุดท้าย
			hArray[load-1] = 0; // ให้ค่าสุดท้ายเป็น 0
			load--; // Update Load Value
			reheapDown(0); //call reheap down starting at Index 0
		}
		return temp; //return ว่า Root เดิมคืออะไร
	}

	/**
     * Sorts the heap in ascending order.
     */
	void makeHeapSort() {
		while(load > 0){ //do it until no nodes left
			System.out.print(deleteRoot() + " ");
		}
		System.out.println();
	}

	/**
     * Finds the level of a given node in the heap.
     *
     * @param nodeIndex The index of the node.
     * @return The level of the node in the heap.
     */
	int findLevel(int nodeindex) {
		int parent = (nodeindex - 1) / 2;
		int level = 0;

		if (parent > 0)
			level++;

		while (parent > 0) {
			parent = (parent - 1) / 2;
			level++;
		}
		return level;
	}

	/**
     * Swaps two elements in the heap array.
     *
     * @param A The heap array.
     * @param ind1 The index of the first element to be swapped.
     * @param ind2 The index of the second element to be swapped.
     */
	void swap(int[] A, int ind1, int ind2) {
		int temp = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = temp;
	}

	/**
     * Prints the elements of the heap array.
     */
	void printHeapArray() {
		for (int i = 0; i < load; i++)
			System.out.print(hArray[i] + " ");
		System.out.println();
	}

//optional
	// Exercise 5: Priority Queue Operations
    /** Inserts an element into the priority queue. */
    public void enqueue(int data) {

        insert(data);
    }

    /** Extracts and returns the maximum element (highest priority) from the priority queue. 
	 * 
	 *  @return the dequeue element
	*/
    public int dequeue() {
    	return deleteRoot();
	}

	/**
     * Checks if the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
	public boolean isEmpty() {
		return load == 0;
	}
}