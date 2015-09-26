package assignment2;

public class List<E extends Data<E>> implements ListInterface<E>  {

	/* Give the specifications and implementation of an ADT for a sorted list
	 * Specification: order --> sorted monotonically increasing
	 * linear order corresponds to the linear order of keys stred in elements in the list
	 */

	// List has to be doubly linked
	Node list;
	Node currentElement;
	Node head;				// points to first element of the list
	Node tail;				// points to last element of the list
	private int size;
	
	List(){
		//Default constructor
	}
	
	/**	@precondition -
	 *  @postcondition - FALSE: list is not empty.
	 *  				TRUE:  list is empty.
	 **/
	public boolean isEmpty(){
		if(head == null) {
			return true;
		} else {
			return false;
		}
	}

	/** @precondition  -
	 *	@postcondition - list-POST is empty and has been returned.
	 **/
	public List<E> init(){
		
	}

	/**	@precondition  -
	 *	@postcondition - The number of elements has been returned.
	 **/
	public int size(){
		return size;
	}

	/** @precondition  -
	 *	@postcondition - A copy of d has been added to List-PRE.
	 *    				current points to the newly added element.
	 *   				list-POST has been returned.
	 **/
	public ListInterface<E> insert(E d){
		if(isEmpty()) {
			currentElement = head = tail = new Node(d, list, null);
		} else {
			// Check waar het element in de lijst moet door compareTO
			// Voeg het aan de lijst toe op de goede plek
		}
		size++;
	}


	/** @precondition  - The list is not empty.
	 *	@postcondition - A copy of the value of the current element has been returned.
	 */
	public E retrieve(){
		return currentElement.data;
	}


	/** @precondition  - The list is not empty.
	 * 	@postcondition - The current element of list-PRE is not present in list-POST.
	 * 	    			current-POST points to
	 *    					- if list-POST is empty
	 *   						null
	 *   					- if list-POST is not empty
	 *     						if current-PRE was the last element of list-PRE
	 *     							the last element of list-POST
	 *     						else 
	 *     							the element after current-PRE 
	 *  				list-POST has been returned.
	 **/
	public ListInterface<E> remove(){
		
	}


	/** @precondition  - 
	 *	@postcondition - TRUE:  list contains a copy of d.
	 *	     			current-POST points to the first element in list that
	 *	     			contains a copy of d.
	 *     				FALSE: list does not contain a copy of d.
	 *	     			current-POST points to
	 *	      				- if list-POST is empty
	 *                    		null
	 *	      				- if the first element in list > d:
	 *                    		the first elmenent in list
	 *        				else
	 *	    					the last element in list with value < d
	 **/
	public boolean find(E d){				// Why no recursion? Is way better..
		currentElement = head;				// current points to the last element in list with value < d????
		for(int i = 0; i < size; i++) {
			if (currentElement.data == d) {
				return true;
			}
			currentElement = currentElement.next;
		}
		return false;
	}


	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty
	 *    				TRUE:  current points to the first element
	 **/
	public boolean goToFirst(){
		if(!isEmpty()) {
			currentElement = head;
			return true;
		} else {
			return false;
		}	
	}


	/**	@precondition  - 
	 *	@postcondition - FALSE: list is empty
	 *     				TRUE:  current points to the last element
	 */
	public boolean goToLast(){
		if(!isEmpty()) {
			currentElement = tail;
			return true;
		} else {
			return false;
		}
	}

	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty or current points to the last element
	 *     				TRUE:  current-POST points to the next element of current-PRE
	 */
	public boolean goToNext(){
		if(isEmpty() || currentElement == tail) {
			return false;
		} else {
			currentElement = currentElement.next;
			return true;
		}
	}

	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty of current wijst het eerste object aan
	 *     				TRUE:  current-POST points to the prior element of current-PRE
	 */
	public boolean goToPrevious(){
		if(isEmpty() || currentElement == head) {
			return false;
		} else {
			currentElement = currentElement.prior;
			return true;
		}
	}

	/** @precondition  -
	 *	@postcondition - A deep-copy of list has been returned.
	 **/
	public ListInterface<E> clone(){
		
	}

	private class Node {
	    E data;
	    Node prior, next;

	    public Node(E d) {
	        this(d, null, null);
	    }

	    public Node(E data, Node prior, Node next) {
	        this.data = data == null ? null : data;
	        this.prior = prior;
	        this.next = next;
	    }
	}
}
