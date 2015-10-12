package assignment3;

import java.util.Iterator;

/** ADT for the class BinarySearchtree.
* @author Nina Lijzenga & Paul Noorland
 * @param <E>
* @elements
*	Elements of type E
* @structure 
*	tree
* @domain
*	What should be here???
* @constructor
*	BinarySearchTree();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new binary searchtree has been created with 0 elements.
*	    </dl>
*	<br>
**/
public interface IBinarySearchtree<E extends Data<E>> extends Clonable<IBinarySearchtree<E>>{ 

	/**	@precondition
	 * -
	 *	@postcondition
	 *		True: The binary searchtree is empty
	 *		False: The binary searchtree not is empty
	 **/
	boolean isEmpty();
	
	/**	@precondition
	 * -
	 *	@postcondition
	 *	binary searchtree POST is empty and has been returned
	 **/
	IBinarySearchtree<E> init();
	
	/**	@precondition  
	 * -
	 *	@postcondition
	 *		True: The binary searchtree contains a copy of element
	 *		False: The binary searchtree does not contain a copy of element
	 **/
	boolean containsElement(E element);
	
	/**	@precondition
	 * -
	 *	@postcondition
	 *	A copy of element has been added to pre- binary searchtree.
	 *	Binary searchtree post has been returned.
	 **/
	IBinarySearchtree<E> insert(E element);
	
	/**	@precondition 
	 * 	The binary searchtree contains element
	 *	@postcondition
	 *	All elements equal to element are not present in binary searchtree post.
	 *	Binary search has been returned
	 **/
	IBinarySearchtree<E> remove(E element);			
	
	/**	@precondition  -
	 *	@postcondition - A deep copy of the binary search tree has been returned
	 **/
	IBinarySearchtree<E> clone();
	
	/**
    * @precondition
    * -
    * @postcondition
	* The data stored in the binary search tree was iterated in monotonically non-decreasing order and was added
	* in this order to an object of the type Iterator<E>. This object of the type Iterator<E> was subsequently 
	* returned.
	**/
   Iterator<E> ascendingIterator ();
    
   /**
    * @precondition
    * -
    * @postcondition
    * The data stored in the binary search tree was iterated in
    * monotonically non-increasing order and was added in this
    * order to an object of the type Iterator<E>.
    * This object of the type Iterator<E> was subsequently
    * returned.
    **/
   Iterator<E> descendingIterator ();
}
