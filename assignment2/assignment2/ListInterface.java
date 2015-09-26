package assignment2;

/**	@elements : objects of type E
 *	@structure : lineair
 *	@domain : 	The elements in the list are sorted monotonically increasing. 
 *				All rows of elements of type E are valid values for a list.
 *       		For every non-empty list the reference current is pointing to an 
 *				element in the list.
 *	@constructor - List();
 *	<dl>
 *		<dt><b>PRE-conditie</b><dd>		-
 *		<dt><b>POST-conditie</b><dd> 	The new List-object is the empty list.
 * </dl>
 **/

public interface ListInterface<E extends Data<E>> extends Clonable<ListInterface<E>> {
	
	/**	@precondition -
	 *  @postcondition - FALSE: list is not empty.
	 *  				TRUE:  list is empty.
	 **/
	boolean isEmpty();

	/** @precondition  -
	 *	@postcondition - list-POST is empty and has been returned.
	 **/
	ListInterface<E> init();

	/**	@precondition  -
	 *	@postcondition - The number of elements has been returned.
	 **/
	int size();

	/** @precondition  -
	 *	@postcondition - A copy of d has been added to List-PRE.
	 *    				current points to the newly added element.
	 *   				list-POST has been returned.
	 **/
	ListInterface<E> insert(E d);


	/** @precondition  - The list is not empty.
	 *	@postcondition - A copy of the value of the current element has been returned.
	 */
	E retrieve();


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
	ListInterface<E> remove();


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
	boolean find(E d);


	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty
	 *    				TRUE:  current points to the first element
	 **/
	boolean goToFirst();


	/**	@precondition  - 
	 *	@postcondition - FALSE: list is empty
	 *     				TRUE:  current points to the last element
	 */
	boolean goToLast();


	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty or current points to the last element
	 *     				TRUE:  current-POST points to the next element of current-PRE
	 */
	boolean goToNext();


	/** @precondition  - 
	 *	@postcondition - FALSE: list is empty of current wijst het eerste object aan
	 *     				TRUE:  current-POST points to the prior element of current-PRE
	 */
	boolean goToPrevious();

	/** @precondition  -
	 *	@postcondition - A deep-copy of list has been returned.
	 **/
	public ListInterface<E> clone();


}