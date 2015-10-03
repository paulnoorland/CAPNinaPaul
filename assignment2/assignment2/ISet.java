package assignment2;

/** ADT for the class Set.
*
* @author Nina Lijzinga & Paul Noorland
* @elements
*	Any type of elements
* @structure 
*	None 
* @domain
*	All elements of type data including the empty set
* @constructor
*	Set();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new set contains 0 elements
*	    </dl>
*	<br>
*	Set(Set set);
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>
*		The new set is a copy of the input set
*	    </dl>
**/

public interface ISet<E extends Data<E>> extends Clonable<ISet<E>> {
	
	/**Initializes a set
	 * @precondition
	 * -
	 * @postcondition
	 * The set is initialized to a empty set
	 */
	void init();
	
	/** Returns an element
	 * @precondition
	 * Set is non-empty
	 * @postcondition
	 * A copy of an element from the set is returned
	 * @return Identifier
	 */
	E getElement();
	
	/** Returns whether an element is in the set
	 * @precondition
	 * -
	 * @postcondition
	 * 	returns:
	 * 		TRUE: 	if the set contains the element
	 * 		FALSE: 	if the set does not contain the element
	 * @return boolean
	 */
	boolean hasElement(E element);
	
	/** Adds an element to the set
	 * @precondition
	 * Element is already in the set							//Is this a pre condition??
	 * @postcondition
	 * The input element is now part of the set
	 * @param element
	 */
	void addElement(E element);
	
	/** Returns the length of the set
	 * @precondition
	 * -
	 * @postcondition
	 * An integer that corresponds to the length of the set is returned
	 * @return
	 */
	int getLength();
	
	/** Returns whether the set is empty
	 * @precondition
	 * -
	 * @postcondition
	 *	returns true if the set is empty
	 *	returns false if the set is not empty
	 */
	boolean isEmpty();
	
	/**Removes an element from the set
	 * @precondition
	 * Set is not empty
	 * @postcondition
	 * An element has been removed from the set
	 * @param element
	 */
	void removeElement(E element);
	
	/** Returns a deep copy of the set
	 * @precondition
	 * -
	 * @postcondition
	 * A deep copy of the set has been returned
	 * @return ISet<E>
	 * 
	 */
	ISet<E> clone();
	
	/** Returns the union of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the elements of the set and the input set has been returned
	 * @param set
	 * @return
	 * The union of the set and the input set
	 */
	ISet<E> union(ISet<E> s2);
	
	/** Returns the difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are only in the first set and not in the second has been returned
	 * @param set
	 * @return
	 * The difference between the set and the input set
	 */
	ISet<E> difference(ISet<E> s2);
	
	/** Returns the intersection of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are both in the set and in input set
	 * @param set
	 * @return
	 * The intersection of the set and the input set
	 */
	ISet<E> intersection(ISet<E> s2);
	
	/** Returns the symmetric difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the identifiers of the set and the input set which are not in the intersection has been returned
	 * @param set
	 * @return
	 * The symmetric difference between the set and the input set
	 */
	ISet<E> symmetricDifference(ISet<E> s2);
}