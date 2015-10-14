package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchtree<E extends Data<E>> implements IBinarySearchtree<E> {

	private TreeNode root;
	private ArrayList<E> list; 

	BinarySearchtree() { // No constructor needed right?

	}

	public boolean isEmpty() {
		return (root == null);
	}

	public IBinarySearchtree<E> init() {
		root = null;
		return this;
	}

	public boolean containsElement(E element) {
		return contains(this.root, element);
	}

	private boolean contains(TreeNode root, E element) {
		if (root == null) {
			return false;
		}
		if (root.data.compareTo(element) > 0) { // element smaller than root
												// data
			return contains(root.left, element);
		} else if (root.data.compareTo(element) == 0) {
			return true;
		} else { // x is bigger than data in the root
			return contains(root.right, element);
		}
	}

	public IBinarySearchtree<E> insert(E element) {
		root = insert(root, element);
		return this;
	}

	// New TreeNode is always added to the bottom of the tree because it bubbles down 
	private TreeNode insert(TreeNode root, E element) { 
		if (root == null) { 							// empty tree
			return new TreeNode(element);
		}
		if (root.data.compareTo(element) > 0) {		// design choice: if x == root.data put x in the right tree
			root.left = insert(root.left, element);
		} else { // x >= root.data
			root.right = insert(root.right, element);
		}
		return root;
	}

	public IBinarySearchtree<E> remove(E element) {
		root = remove(root, element);
		return this;
	}

	private TreeNode remove(TreeNode root, E element) {
		if (root == null) {
			throw new Error(); 								// Not in tree
		}
		if (root.data.compareTo(element) > 0) {
			root.left = remove(root.left, element);
		} else if (root.data.compareTo(element) < 0) {
			root.right = remove(root.right, element);
		} else { 										// know for sure that x is present
			// For 0 or 1 child
			if (root.left == null) {
				root = root.right; 						// if right is null then node is removed
			} else if (root.right == null) { 			// Works also for 0 children
				root = root.left;
			} else {
				// 2 children
				root.data = smallest(root.right); 			// Method that returns smallest value
				root.right = remove(root.right, root.data);
			}
		}
		return root;
	}

	private E smallest(TreeNode root) {
		return root.left == null ? root.data : smallest(root.left);
	}

	public IBinarySearchtree<E> clone() {
		BinarySearchtree<E> tree = new BinarySearchtree<E>();
		tree.root = root.clone();
		return tree;
	}
	
	public Iterator<E> ascendingIterator() {
		list = new ArrayList<E>();
		inOrder(root);
		return list.iterator();
	}
	
	private void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);	
		list.add(root.data.clone());
		inOrder(root.right);
	}

	public Iterator<E> descendingIterator() {
		list = new ArrayList<E>();
		reversedOrder(root);
		return list.iterator();
	}
	
	private void reversedOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		reversedOrder(root.right);	
		list.add(root.data.clone());
		reversedOrder(root.left);
	}

	private class TreeNode implements Clonable<TreeNode>{
		E data;
		TreeNode left, right;

		public TreeNode(E d) {
			this(d, null, null);
		}

		public TreeNode(E data, TreeNode left, TreeNode right) {
			this.data = data == null ? null : data;
			this.left = left;
			this.right = right;
		}
		
		public TreeNode clone() {
			TreeNode copy = new TreeNode(data);
			copy.left = left == null ? null : left.clone();
			copy.right = right == null ? null : right.clone();
			copy.data = data.clone();
			return copy;
		}
	}
}
