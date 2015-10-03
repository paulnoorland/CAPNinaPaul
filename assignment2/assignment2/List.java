package assignment2;

public class List<E extends Data<E>> implements ListInterface<E>  {

	/* Give the specifications and implementation of an ADT for a sorted list
	 * Specification: order --> sorted monotonically increasing
	 * linear order corresponds to the linear order of keys stred in elements in the list
	 */

	//TODO: What happens with elements with a key that's already in the list?????
	Node currentElement;
	Node head;				// points to first element of the list
	Node tail;				// points to last element of the list
	
	private int size;
	
	List(){
		init();
	}
	
	/**	@precondition -
	 *  @postcondition - FALSE: list is not empty.
	 *  				TRUE:  list is empty.
	 **/
	public boolean isEmpty(){				
		return (size == 0);	
	}

	/** @precondition  -
	 *	@postcondition - list-POST is empty and has been returned.
	 **/
	public List<E> init(){
		head = null;
		tail = null;
		currentElement = null;
		size = 0;
		return this;
	}

	/**	@precondition  -
	 *	@postcondition - The number of elements has been returned.
	 **/
	public int size(){
		return size;
	}

	private void placeNode(Node newNode, Node before, Node after) {
		newNode.prior = before;
		newNode.next = after;
		if(after != null) after.prior = newNode;
		if(before != null) before.next = newNode;
	}
	
	/** @precondition  -
	 *	@postcondition - A copy of d has been added to List-PRE.
	 *    				current points to the newly added element.
	 *   				list-POST has been returned.
	 **/
	public ListInterface<E> insert(E d){			//What has to be current element?
		if(isEmpty()) {													// EMPTY LIST
			currentElement = head = tail = new Node(d.clone(), null, null);		// Watch for reference errors
		} else {
			goToFirst();
			Node newNode = new Node(d.clone(), null, null);
			if(newNode.data.compareTo(currentElement.data) < 0) {		// Add in front
				placeNode(newNode, null, currentElement);
				head = newNode;
			} else {
				int j;
				for(j = 1; j < size; j++) {							// Add in the middle
					if(currentElement.data.compareTo(newNode.data) < 0) {
						goToNext();
					} else {
						placeNode(newNode, currentElement.prior, currentElement);
						break;
					}
				}
				if (j == size) {											// Better solution please Sebas
					placeNode(newNode, currentElement, null); 				// Add to end //Check if this works because of null.prior
					tail = newNode;
				}
			}
			currentElement = newNode;		//too dirty? Was needed for the go to next...
		}
		size++;
		return this;
	}


	/** @precondition  - The list is not empty.
	 *	@postcondition - A copy of the value of the current element has been returned.
	 */
	public E retrieve(){
		return currentElement.data.clone();
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
		if(size == 1) {												//Remove the only element
			head = tail = currentElement = null;
		} else if(currentElement == head) {							//Remove first element
			head = currentElement.next;
			head.prior = null;
			currentElement = head;
		} else if(currentElement == tail) {							//Remove last element
			tail = currentElement.prior;
			currentElement = tail;
			currentElement.next = null;
		} else {													//Remove element in middle
			currentElement.prior.next = currentElement.next;
			currentElement.next.prior = currentElement.prior;
			currentElement = currentElement.next;
		}
		size--;
		return this;
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
		goToFirst();						// current points to the last element in list with value < d????
		for(int i = 0; i < size; i++) {
			if (currentElement.data == d) {			// Is this correct or should we use compareTo
				return true;
			}
			goToNext();
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
		List<E> clone = new List<E>();
		E currentElementClone = currentElement.data.clone();
		goToFirst();
		for (int i = 0; i < size; i++) {
			insert(currentElement.data.clone());
			goToNext();
		}
		clone.find(currentElementClone);		//This causes the currentElement to equal the parameter
		return clone;
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
