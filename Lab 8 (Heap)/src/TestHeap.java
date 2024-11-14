public class TestHeap {
	public static void main(String[] args) {
		Heap H = new Heap(); // create a heap with a max size 100 (default size)

		System.out.println("Ex 1-2: Testing insert and reheapUp methods:");
		// The correct answer is 99 81 90 54 72 45 36 0 27 18 63 9
		System.out.println("Your HeapArray contains ");
		for (int i = 0; i < 100; i = i + 9) {
			H.insert(i);
		}
		H.printHeapArray();

		// Uncomment the following code to test Ex3-4a
		// The correct answer is 90 81 45 54 72 9 36 0 27 18 63
		System.out.println("\nEx 3-4a: Testing deleteRoot and reheapDown methods:");
		H.deleteRoot();
		System.out.println("Your HeapArray contains ");
		H.printHeapArray();

		// Uncomment the following code to test Ex4b
		// The correct answer is 90 81 72 63 54 45 36 27 18 9 0
		System.out.println("\nEx 4b: Testing HeapSort");
		System.out.println("Your sequence from HeapSort is ");
		H.makeHeapSort();

		// Testing priority queue operations
        System.out.println("\nEx 5: Testing Priority Queue operations:");
        Heap priorityQueue = new Heap();
        priorityQueue.enqueue(4);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(1);
        System.out.println("Priority Queue after enqueuing 4, 2, 5, 1:");
        priorityQueue.printHeapArray();

        System.out.println("Dequeue: " + priorityQueue.dequeue()); // Expected: 5
        System.out.println("Priority Queue after dequeue:");
        priorityQueue.printHeapArray();

        System.out.println("Dequeue: " + priorityQueue.dequeue()); // Expected: 4
        System.out.println("Priority Queue after dequeue:");
        priorityQueue.printHeapArray();

		System.out.println("Is Priority Queue Empty? " + priorityQueue.isEmpty()); // Should be false

		System.out.println("Dequeue: " + priorityQueue.dequeue()); // Expected: 2
        System.out.println("Priority Queue after dequeue:");
        priorityQueue.printHeapArray();

		System.out.println("Dequeue: " + priorityQueue.dequeue()); // Expected: 1
        System.out.println("Priority Queue after dequeue:");
        priorityQueue.printHeapArray();

		System.out.println("Is Priority Queue Empty? " + priorityQueue.isEmpty()); // Should be true

		// Suggestion
        System.out.println("\nSuggestion: You can also try implementing a min heap priority queue where the smallest element has the highest priority.");
	}

}