package SList;

/**
 * The {@code SList} class represents a singly linked list that can hold
 * elements of a generic type {@code T}. It provides methods for adding elements
 * to the beginning and end of the list, adding elements at a specified index,
 * removing elements from the beginning and end of the list, removing elements
 * at a specified index, checking if the list is empty, obtaining the size of
 * the list, and searching for elements within the list.
 *
 * @param <T> The type of elements stored in the singly linked list.
 */
public class SList<T> {
	int size; // The number of elements currently stored in the SList.
	SNode<T> first; // The reference to the first node in the SList.
	SNode<T> last; // The reference to the last node in the SList.

	SList() { // Constructs an empty singly linked list with size 0.
		size = 0;
		first = null;
		last = null;
	}

	/**
	 * Adds a new element to the beginning of the singly linked list.
	 * 
	 * @param element The element to be added to the list.
	 */
	void addFirst(T element) {
		SNode<T> newNode = new SNode<T>(element);
		newNode.next = first;
		first = newNode;
		size += 1;
		if (last == null) {
			last = first;
		}
	}

	/**
	 * Adds a new element to the end of the singly linked list.
	 *
	 * @param element The element to be added to the list.
	 */
	void addLast(T element) {
		SNode<T> newNode = new SNode<T>(element);
		// newNode.next = null; บรรทัดนี้ลบทิ้งไปได้ เพราะว่าใน constructor ของ SNode
		// ตั้งไว้อยู่แล้วว่า next เป็น null
		if (size == 0) {
			first = newNode;
		} else {
			last.next = newNode;
		}
		last = newNode;
		size += 1;
	}

	/**
	 * Adds a new element at the specified index in the singly linked list. If the
	 * index is 0, the element is added to the beginning of the list. If the index
	 * is greater than or equal to the size, the element is added to the end of the
	 * list.
	 *
	 * @param index   The index at which to add the element.
	 * @param element The element to be added to the list.
	 */
	void addAtIndex(int index, T element) {
		// เขียนเผื่อทุกกรณีเลย
		if (index == 0) {
			addFirst(element);
		} else if (index >= size) {
			addLast(element);
		} else {
			SNode<T> current = first; // อันนี้เอามาเหมือนเป็น Temp ไว้ข้างหน้า
			SNode<T> newNode = new SNode<T>(element);
			for (int i = 0; i < index - 1; i++) { // Shift element ทุกตัวไปข้างหน้า
				// เพื่อจะวางตัวที่เราจะ addAtIndex เข้าไป
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			size += 1;
		}
	}

	/**
	 * Removes and returns the first element from the singly linked list.
	 *
	 * @return The removed element, or {@code null} if the list is empty.
	 */
	T removeFirst() {
		if (size == 0) // ถ้า Size = 0 แล้วจะ remove อะไร...?
			return null;
		else {
			SNode<T> tmp = first;
			first = first.next;
			size -= 1;
			if (first == null)
				last = null;
			return tmp.element;
		}

	}

	/**
	 * Removes and returns the last element from the singly linked list.
	 *
	 * @return The removed element, or {@code null} if the list is empty.
	 */
	T removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			SNode<T> tmp = first;
			first = null;
			last = null;
			size -= 1;
		} else {
			SNode<T> current = first;
			SNode<T> tmp = last;

			while (current.next != last) { // Move the pointer
				current = current.next;
			}
			last = current;
			last.next = null;
			size--;
		}
		return last.element;
	}

	/**
	 * Removes and returns the element at the specified index in the singly linked
	 * list.
	 *
	 * @param index The index of the element to be removed.
	 * @return The removed element, or {@code null} if the index is out of bounds.
	 */
	T removeAtIndex(int index) {
		if (size == 0) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			SNode<T> tmp = first;
			for (int i = 0; i < index - 1; i++) { // Move the pointer
				tmp = tmp.next;
			}
			SNode<T> removeNode = tmp.next;
			tmp.next = tmp.next.next;
			removeNode.next = null;
			size -= 1;
			return removeNode.element;
		}
	}

	/**
	 * Checks whether the singly linked list is empty.
	 *
	 * @return {@code true} if the list is empty, {@code false} otherwise.
	 */
	boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * Returns the current size of the singly linked list.
	 *
	 * @return The number of elements in the list.
	 */
	int getSize() {
		return size;
	}

// Implement the reversal of the linked list
	// Ex. 4 complete the method
	void reverse() {
		SNode<T> previous = null;
		SNode<T> current = first;
		SNode<T> next = null;
		while (current != null) { // Complete the condition
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		first = previous;
	}

	/**
	 * Searches for the first occurrence of a specified item in the singly linked
	 * list and returns its index.
	 *
	 * @param item The item to search for.
	 * @return The index of the first occurrence of the item, or {@code -1} if not
	 *         found.
	 */
	int search(T item) {
		SNode<T> current = first;
		int i = 0;
		while (current != null) {
			if (current.element.equals(item)) {
					return i;
			}
					else {
						i++;
						current = current.next;
					}
		}
		return -1;
	}

	/**
	 * Prints the elements of the singly linked list horizontally, followed by a
	 * horizontal line separator. This method is primarily used for debugging and
	 * displaying the contents of the list.
	 */
	void printHorizontal() {
		SNode<T> walker = first;
		for (int i = 0; i < size; i++) {
			System.out.print(walker.element);
			System.out.print(" ");
			walker = walker.next;
		}
		System.out.println("\n-----");
	}

}