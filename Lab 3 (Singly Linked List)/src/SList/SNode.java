package SList;

/**
 * The {@code Node} class represents a node in a singly linked list.
 *
 * @param <T> The type of data stored in the node.
 */
class SNode<T> {
	T element; // The data element stored in the node.
	SNode<T> next; //Reference to the next node in the linked list.
	
	SNode(T element) { // Constructs a new node with the specified data element.
		// @param element The data element to store in the node.
		this.element = element;
		next = null;
	}

}
