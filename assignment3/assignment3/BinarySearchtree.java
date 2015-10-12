package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

import assignment2.Data;

public class BinarySearchtree<E extends Data<E>> implements IBinarySearchtree<E>{

	TreeNode root;
	
	BinarySearchtree() {			// No constructor needed right?
		
	}
	
	// How to make sure that it satisfies requirements of a binary search tree??
	
	



	public boolean isEmpty() {
		return (root == null);
	}

	public IBinarySearchtree<E> init() {
		root = null;
		return this;
	}

	public boolean containsElement(E element) {
		return contains(this.root, element);		// Is this safe?
	}

	private boolean contains(TreeNode root, E element) {
		if (root == null) {
			return false;
		}
		if (root.data.compareTo(element) > 0) {				// element smaller than root data
			return contains(root.left, element);
		} else if (root.data.compareTo(element) == 0)	{
			return true;
		} else {								//x is bigger than data in the root
			return contains(root.right, element);
		}
	}

	public IBinarySearchtree<E> insert(E element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private TreeNode insert(TreeNode root, E element) {		//this doesn't work.. Matty told us this..
		if (root == null) {				// empty tree
			return new TreeNode(element);
		}
		//design choice: if x == root.data put x in the right tree
		if (root.data.compareTo(element) > 0) {
			root.left = insert(root.left, element);
		} else {						//x <= root.data
			root.right = insert(root.right, element);
		}
		return root;
	}



	@Override
	public IBinarySearchtree<E> remove(E element) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public E smallest() {
		return root.left == null ? root.data : smallest(root.left);
	}


	@Override
	public IBinarySearchtree<E> clone() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterator<E> ascendingIterator() {
		// TODO Auto-generated method stub
		
		// arraylist
		ArrayList<E> list = new ArrayList<E>();
		return list.iterator();
	}
	
	


	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class TreeNode {
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
	}
}
