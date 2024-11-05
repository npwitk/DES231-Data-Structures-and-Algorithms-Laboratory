public class BST<T extends Comparable<T>> extends BT<T> {
	/** Create an empty binary tree */
	public BST() {

	}

	/** Create a binary tree from an object */
	public BST(T object) {
		root.element = object;
	}

	/** Create a binary tree from an array of objects */
	public BST(T[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	// ----------------------------------------------
	/**
	 * Insert newdata into the binary search tree
	 */
	public void insert(T newdata) {
		// Ex1: Complete this program
		if (root == null) {
			root = new BTNode<T>(newdata); // Start with nothing, create a new root
		} else { // Have something at first
			// Locate the parent node
			BTNode<T> parent = null;
			BTNode<T> current = root;

			while(current != null) {
				parent = current;
				if (newdata.compareTo(current.element) <= 0) { //if newdata <= current, put left
					// newdata LESS THAN OR EQUAL TO current
					current = current.left;
				} else if (newdata.compareTo(current.element) > 0) { //if newdata > current, go right
					// newdata MORE THAN 
					current = current.right;
				}
				// Move the pointer downward to search where the next spot should be.
			}
			
			if (newdata.compareTo(parent.element) <= 0) { // to insert the newnode
				parent.left = new BTNode<T>(newdata); // assign newnode to left
				// newnode LESS THAN OR EQUAL TO its parent
			} else {
				parent.right = new BTNode<T>(newdata); // assign newnode to right
				// newnode MORE THAN its parent
			}
		}
		size++;
	}

	// ----------------------------------------------
	/**
	 * Delete data from the binary search tree
	 */
	// Ex2. Complete This Program
	public T delete(T item) {
		// Locate the node to be deleted and also locate its parent node
		BTNode<T> parent = null;
		BTNode<T> current = root;

		boolean currentIsLeftChild = true;

		while (current != null) {
			
			//Search for the item we want to delete (Compare step)
			if (item.compareTo(current.element) < 0) { //if item < current element, go left
				parent = current;
				current = current.left;
				currentIsLeftChild = true;
			} else if (item.compareTo(current.element) > 0) { //if item > current element, go right
				parent = current;
				current = current.right;
				currentIsLeftChild = false;
			} else {
				break;
			}
			
		}

		// Case 0: item is not in the tree
		if (current == null) {
			return null;
		}
		T temp = current.element;
		
		// Case 1: current is the leave
		if (current.left == null && current.right == null) {
			if (currentIsLeftChild) { //ถ้าเป็นลูกฝั่ง Left
				parent.left = null;
			} else { // ถ้าเป็นลูกฝั่ง Right
				parent.right = null;
			} //ก็ไม่ต้องให้ Parent เชื่อมต่ออีกต่อไปปปป
		}

		// Case 2: If the deleted node has one child
		
			// Case 2.1: if its child node is on the right of its parent
			if ((current.left == null)) { // If only has one right child or no children.
				if (currentIsLeftChild) {
					if (parent == null) { //it is the root (if we're goin to delete the root)
						root = current.right; // there's no leftsub for the previous root, so when it deleted the root,
						// the right child of the root will be the next root
					}
				} else {
					///it is not the root, current is left child, it has no current. left so when it deleted current,
					// it has to link parent.left with the current.right
					parent.left = current.right;
					current.right = null; //disconnect the link of temp(current)
				}
			}
		
			// Case 2.2: If its child node is on the left of its parent
			else if ((current.right == null)) { // Only one left child
				if (currentIsLeftChild) {
					if (parent == null) { // ในกรณีที่มีแค่ 2 ตัว แล้วจะ delete root
						root = current.left; //there's no rightsub for the previous root, so when it deleted the root,
						// the left child of the root will be the next root
					}
					else { 
						parent.left = current.left; // โยงข้ามไปลูกของ Current ที่อยู่ฝั่งซ้าย
						current.left = null; // Disconnect the link of current กับลูกมัน

					}
				} else { //current is right child
					// insert your code
					if (parent == null){ // ในกรณีที่มีแค่ 2 ตัว แล้วจะ delete root
						root = current.left; //there's no rightsub for the previous root, so when it deleted the root,
						// the left child of the root will be the next root
					}
					else{ //it is not root, current is right child, it has no current.right so when it deleted current,
						// it has to link parent.right with the current.left
						parent.right = current.left;
						current.left = null; //disconnect the link of temp(current)
					}
				}
			} else { // Case 3: Have both children
				
				BTNode<T> maxleft = current.left;
				BTNode<T> maxleftParent = current;
				
				while (maxleft.right != null) {
					maxleftParent = maxleft;
					maxleft = maxleft.right;
				}
				
				current.element = maxleft.element; // Replace the current with maxleft
				
				if (maxleft.left == null && maxleft.right == null) { // Case 3.1 if maxleft is a leave,
					// then replace the temp(current) with maxleft, then set maxleftParent to have no child (unlink)
					
					maxleftParent.right = null; //unlink maxleftParent with maxleft
				} else if (maxleft.left != null) { // Case 3.2 if maxleft has a left child,
					// then replace the temp(current) with maxleft, make maxleft.left be the right child of maxleftParent
					maxleftParent.right = maxleft.left; //connect maxleftParent with maxleft.left
					maxleft.left = null; //unlink maxleft with maxleft.left
				} else if (maxleftParent == current) { // Case 3.3 if maxleft is leftchild of current,
					// then replace the temp(current) with maxleft, make maxleft.left be the leftchild of temp(current.left)
					current.left = maxleft.left; //connect temp(current) with maxleft.left
					maxleft.left = null; //unlink maxleft with maxleft.left
				}
			}
			size--;
			return temp;
	}
	// ---------------------------------------------------------

	// Search for the data returns true if it finds the data or otherwise false
	public boolean search(T data) { 
		// Ex 3: Complete this section.
				//replace the following line with your code
				BTNode<T> current = root;
				while (current != null){
					if (data.compareTo(current.element) < 0) { //if data <= current, go left in search we compare just for < 0
						//if we use <= 0 it'll haas a problem when it matches, it will continue going left but it should stop there so we need to use < 0zsz
						current = current.left;
					}
					else if (data.compareTo(current.element) > 0) { //if newdata > current, go right
						current = current.right;
					}
					else { //element matches with current.element
						return true;
					}
				}
				return false;
			}

	// ---------------------------------------------------------

	BTNode<T> findSmallest() {
		return findSmallest(root);
	}

	// ----------------------------------------------
	BTNode<T> findSmallest(BTNode<T> start) {
		// Ex 4: Complete this section.
		//replace the following line with your code
		BTNode<T> smallest = start;
		while (smallest.left != null) {
			smallest = smallest.left;
		}
		if (smallest.left == null){
			return smallest;
		}
		else {
			return null;
		}
	}

	// ----------------------------------------------
	BTNode<T> findLargest() {
		return findLargest(root);
	}

	// ----------------------------------------------
	BTNode<T> findLargest(BTNode<T> start) { 
		// Ex 5: Complete this section.
		//replace the following line with your code
		BTNode<T> largest = start;
		while (largest.right != null){
			largest = largest.right;
		}
		if (largest.right == null){
			return largest;
		}
		else {
			return null;
		}
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public BTNode getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<BTNode<T>> path(T e) {
		java.util.ArrayList<BTNode<T>> list = new java.util.ArrayList<BTNode<T>>();
		BTNode<T> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list; // Return an array of nodes
	}

	 /** Exercise 5: Implement method to find the closest value in BST */
	public T findClosestValue(T target) {
		return findClosestValue(root, target, root.element);
	}

	private T findClosestValue(BTNode<T> node, T target, T closest) {
		if (node == null) {
			return closest; 
		}

		// Convert the target and node elements to Double for easier comparison
		Double targetVal = Double.valueOf(target.toString());
		Double nodeVal = Double.valueOf(node.element.toString());
		Double closestVal = Double.valueOf(closest.toString());

		// Update the closest value if the current node's value is closer to the target
		if (Math.abs(targetVal - nodeVal) < Math.abs(targetVal - closestVal)) {
			closest = node.element;
		}

		// Recursively search left or right subtree based on comparison
		// use x.compareTo(y) to check if target is more or lesser than node.element

		if (target.compareTo(node.element) < 0) {
			return findClosestValue(node.left, target, closest);
		} else if (target.compareTo(node.element) > 0) {
			return findClosestValue(node.right, target, closest); 
		} else {
			return node.element; 
		}
	}

}